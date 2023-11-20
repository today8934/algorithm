package com.example.algorithm.dfs;

import java.util.ArrayList;

public class Network {

    private static ArrayList<Integer>[] computerArray;
    private static boolean[] visited;

    public static void main(String[] args) {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 1;
        array[0][2] = 0;
        array[1][0] = 1;
        array[1][1] = 1;
        array[1][2] = 0;
        array[2][0] = 0;
        array[2][1] = 0;
        array[2][2] = 1;

        System.out.println(solution(3, array));
    }

    public static int solution(int n, int[][] computers) {
        computerArray = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            computerArray[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    computerArray[i].add(j);
                    computerArray[j].add(i);
                }
            }
        }

        int networksCount = 0;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i);
                networksCount++;
            }
        }

        return networksCount;
    }

    private static void dfs(int index) {
        if (visited[index]) return;
        visited[index] = true;

        for (int i: computerArray[index]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
