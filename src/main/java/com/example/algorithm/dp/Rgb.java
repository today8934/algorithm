package com.example.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rgb {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());

        int[][] costArr = new int[count][3];

        for (int i = 0; i < count; i++) {
            String cost = bufferedReader.readLine();

            costArr[i][RED] = Integer.parseInt(cost.split(" ")[0]);
            costArr[i][GREEN] = Integer.parseInt(cost.split(" ")[1]);
            costArr[i][BLUE] = Integer.parseInt(cost.split(" ")[2]);
        }

        for (int i = 1; i < count; i++) {
            costArr[i][RED] += Math.min(costArr[i - 1][GREEN], costArr[i - 1][BLUE]);
            costArr[i][GREEN] += Math.min(costArr[i - 1][RED], costArr[i - 1][BLUE]);
            costArr[i][BLUE] += Math.min(costArr[i - 1][RED], costArr[i - 1][GREEN]);
        }

        System.out.println(Math.min(costArr[count - 1][BLUE], Math.min(costArr[count - 1][RED], costArr[count - 1][GREEN])));
    }
}
