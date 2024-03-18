package com.example.algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon10026 {

    private static boolean[][] visited;
    private static Map<String, ArrayList<String>> nodeMap = new HashMap<>();

    private static final Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[count][count];
        String[][] map = new String[count][count];

        for (int i = 0; i < count; i++) {
            String[] line = bufferedReader.readLine().split("");
            for (int j = 0; j < count; j++) {
                visited[i][j] = false;
                map[i][j] = line[j];
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                String rgb = map[i][j];
                ArrayList<String> node = new ArrayList<>();
                if (i < count - 1 && rgb.equals(map[i + 1][j])) node.add(String.format("%s-%s", i + 1, j));
                if (j < count - 1 && rgb.equals(map[i][j + 1])) node.add(String.format("%s-%s", i, j + 1));
                if (i > 0 && rgb.equals(map[i - 1][j])) node.add(String.format("%s-%s", i - 1, j));
                if (j > 0 && rgb.equals(map[i][j - 1])) node.add(String.format("%s-%s", i, j - 1));
                nodeMap.put(String.format("%s-%s", i, j), node);
            }
        }

        int result = 0;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (!visited[i][j]) {
                    result++;
                    queue.add(String.format("%s-%s", i, j));
                    bfs();
                }
            }
        }

        visited = new boolean[count][count];
        nodeMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                visited[i][j] = false;
                map[i][j] = "G".equals(map[i][j]) ? "R" : map[i][j];
            }
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                String rgb = map[i][j];
                ArrayList<String> node = new ArrayList<>();
                if (i < count - 1 && rgb.equals(map[i + 1][j])) node.add(String.format("%s-%s", i + 1, j));
                if (j < count - 1 && rgb.equals(map[i][j + 1])) node.add(String.format("%s-%s", i, j + 1));
                if (i > 0 && rgb.equals(map[i - 1][j])) node.add(String.format("%s-%s", i - 1, j));
                if (j > 0 && rgb.equals(map[i][j - 1])) node.add(String.format("%s-%s", i, j - 1));
                nodeMap.put(String.format("%s-%s", i, j), node);
            }
        }

        int colorResult = 0;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (!visited[i][j]) {
                    colorResult++;
                    queue.add(String.format("%s-%s", i, j));
                    bfs();
                }
            }
        }

        System.out.println(result + " " + colorResult);
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            String poll = queue.poll();
            int pollX = Integer.parseInt(poll.split("-")[0]);
            int pollY = Integer.parseInt(poll.split("-")[1]);
            visited[pollX][pollY] = true;

            if (nodeMap.get(poll) != null) {
                nodeMap.get(poll).forEach(node -> {
                    int nodeX = Integer.parseInt(node.split("-")[0]);
                    int nodeY = Integer.parseInt(node.split("-")[1]);
                    if (!visited[nodeX][nodeY]) {
                        queue.add(node);
                    }
                });
            }
        }
    }
}
