package com.example.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());

        int[][] triangle = new int[count][count];

        for (int i = 0; i < count; i++) {
            String[] lineArray = bufferedReader.readLine().split(" ");
            for (int j = 0; j < lineArray.length; j++) {
                if (i == 0) {
                    triangle[i][j] = Integer.parseInt(lineArray[j]);
                } else {
                    if (j == 0) {
                        triangle[i][j] = triangle[i - 1][j] + Integer.parseInt(lineArray[j]);
                    } else if (j == lineArray.length - 1) {
                        triangle[i][j] = triangle[i - 1][j - 1] + Integer.parseInt(lineArray[j]);
                    } else {
                        triangle[i][j] = Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]) + Integer.parseInt(lineArray[j]);
                    }
                }
            }
        }

        System.out.println(Arrays.stream(triangle[count - 1]).max().getAsInt());
    }
}
