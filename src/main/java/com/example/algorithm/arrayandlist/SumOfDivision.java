package com.example.algorithm.arrayandlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int dataCount = Integer.parseInt(stringTokenizer.nextToken());
        int quizCount = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] sumArray = new int[dataCount];

        for (int i = 0; i < dataCount; i++) {
            int data = Integer.parseInt(stringTokenizer.nextToken());

            if (i == 0) sumArray[i] = data;
            else sumArray[i] = sumArray[i - 1] + data;
        }

        for (int i = 0; i < quizCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startIndex = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int endIndex = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            if (startIndex == 0) {
                System.out.println(sumArray[endIndex]);
            } else {
                System.out.println(sumArray[endIndex] - sumArray[startIndex - 1]);
            }
        }
    }
}
