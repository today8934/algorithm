package com.example.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, Integer> target = new HashMap<>();

        for (int i = 0; i < count; i++) {
            int k = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());

            target.put(k, n);
        }

        int[][] apartment = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apartment[i][1] = 1;
            apartment[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
            }
        }

        for (int i: target.keySet()) {
            System.out.println(apartment[i][target.get(i)]);
        }
    }
}
