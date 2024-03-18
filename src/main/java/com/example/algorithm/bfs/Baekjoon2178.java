package com.example.algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2178 {

    private static final Map<String, ArrayList<String>> nodeMap = new HashMap<>();
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String nm = bufferedReader.readLine();
        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);

        int[][] map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayList<String> node = new ArrayList<>();
                if (i < n - 1 && map[i + 1][j] == 1) node.add(String.format("%s-%s", i + 1, j));
                if (j < m - 1 && map[i][j + 1] == 1) node.add(String.format("%s-%s", i, j + 1));
                if (i > 0 && map[i - 1][j] == 1) node.add(String.format("%s-%s", i - 1, j));
                if (j > 0 && map[i][j - 1] == 1) node.add(String.format("%s-%s", i, j - 1));
                nodeMap.put(String.format("%s-%s", i, j), node);
            }
        }

        System.out.println(bfs(n, m));
    }

    private static int bfs(int n, int m) {
        Queue<String> queue = new LinkedList<>();
        queue.add("0-0-1");
        visited[0][0] = true;

        Set<Integer> resultSet = new HashSet<>();

        while(!queue.isEmpty()) {
            String poll = queue.poll();
            int x = Integer.parseInt(poll.split("-")[0]);
            int y = Integer.parseInt(poll.split("-")[1]);
            int count = Integer.parseInt(poll.split("-")[2]);
            visited[x][y] = true;
            if (nodeMap.get(String.format("%s-%s", x, y)) != null) {
                nodeMap.get(String.format("%s-%s", x, y)).forEach(node -> {
                    int nextX = Integer.parseInt(node.split("-")[0]);
                    int nextY = Integer.parseInt(node.split("-")[1]);
                    if (!visited[nextX][nextY]) {
                        queue.add(String.format("%s-%s-%s", nextX, nextY, count + 1));
                    }
                });
            }

            if (x == n - 1 && y == m - 1) {
                resultSet.add(count);
            }
        }

        return resultSet.stream().min(Integer::compareTo).get();
    }
}
