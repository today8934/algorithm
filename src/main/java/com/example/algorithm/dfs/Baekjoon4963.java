package com.example.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon4963 {

    private static final ArrayList<Integer> resultArray = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String readLine = bufferedReader.readLine();

            if (readLine.equals("0 0")) {
                resultArray.forEach(System.out::println);
                break;
            } else {
                int x = Integer.parseInt(readLine.split(" ")[0]);
                int y = Integer.parseInt(readLine.split(" ")[1]);
                int[][] map = new int[y][x];
                for (int i = 0; i < y; i++) {
                    String[] line = bufferedReader.readLine().split(" ");
                    for (int j = 0; j < x; j++) {
                        map[i][j] = Integer.parseInt(line[j]);
                    }
                }
                resultArray.add(doProcess(map, y, x));
            }
        }
    }

    private static int doProcess(int[][] map, int y, int x) {
        boolean[][] visited = new boolean[y][x];
        Map<String, ArrayList<String>> nodeMap = new HashMap<>();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                visited[i][j] = false;
                if (map[i][j] == 1) {
                    ArrayList<String> node = new ArrayList<>();
                    if (i < y - 1 && map[i + 1][j] == 1) node.add(String.format("%s-%s", i + 1, j));
                    if (j < x - 1 && map[i][j + 1] == 1) node.add(String.format("%s-%s", i, j + 1));
                    if (i > 0 && map[i - 1][j] == 1) node.add(String.format("%s-%s", i - 1, j));
                    if (j > 0 && map[i][j - 1] == 1) node.add(String.format("%s-%s", i, j - 1));
                    if (i < y - 1 && j < x - 1 && map[i + 1][j + 1] == 1) node.add(String.format("%s-%s", i + 1, j + 1));
                    if (i < y - 1 && j > 0 && map[i + 1][j - 1] == 1) node.add(String.format("%s-%s", i + 1, j - 1));
                    if (i > 0 && j < x - 1 && map[i - 1][j + 1] == 1) node.add(String.format("%s-%s", i - 1, j + 1));
                    if (i > 0 && j > 0 && map[i - 1][j - 1] == 1) node.add(String.format("%s-%s", i - 1, j - 1));
                    nodeMap.put(String.format("%s-%s", i, j), node);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    result++;
                    dfs(i, j, visited, nodeMap);
                }
            }
        }

        return result;
    }

    private static void dfs(int i, int j, boolean[][] visited, Map<String, ArrayList<String>> nodeMap) {
        if (visited[i][j]) return;
        visited[i][j] = true;

        nodeMap.get(String.format("%s-%s", i, j)).forEach(node -> {
            int x = Integer.parseInt(node.split("-")[0]);
            int y = Integer.parseInt(node.split("-")[1]);
            if (!visited[x][y]) {
                dfs(x, y, visited, nodeMap);
            }
        });
    }
}
