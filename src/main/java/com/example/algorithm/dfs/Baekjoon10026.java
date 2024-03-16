package com.example.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon10026 {

    private static boolean[][] visited;
    private static Map<String, ArrayList<String>> nodeMap = new HashMap<>();
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        visited = new boolean[count][count];
        map = new String[count][count];
        for (int i = 0; i < count; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < count; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int normaCount = doProcess(count);

        visited = new boolean[count][count];
        nodeMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                map[i][j] = "G".equals(map[i][j]) ? "R" : map[i][j];
            }
        }

        int colorBlindCount = doProcess(count);

        System.out.printf("%s %s%n", normaCount, colorBlindCount);
    }

    private static int doProcess(int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                visited[i][j] = false;
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
                    dfs(i, j);
                }
            }
        }

        return result;
    }

    private static void dfs(int i, int j) {
        if (visited[i][j]) return;
        visited[i][j] = true;

        nodeMap.get(String.format("%s-%s", i, j)).forEach(node -> {
            int x = Integer.parseInt(node.split("-")[0]);
            int y = Integer.parseInt(node.split("-")[1]);
            if (!visited[x][y]) {
                dfs(x, y);
            }
        });
    }
}
