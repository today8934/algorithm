package com.example.algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] numberArr = new int[count];

        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            numberArr[i] = number;
        }

        Arrays.sort(numberArr);

        int result = 0;

        for (int k = 0; k < count; k++) {
            int startIndex = 0;
            int endIndex = count - 1;
            int goodNumber = numberArr[k];

            while (startIndex != endIndex) {
                int sum = numberArr[startIndex] + numberArr[endIndex];

                if (sum == goodNumber) {
                    if (startIndex == k) {
                        startIndex++;
                    } else if (endIndex == k) {
                        endIndex--;
                    } else {
                        result++;
                        break;
                    }
                } else if (sum > goodNumber) {
                    endIndex--;
                } else {
                    startIndex++;
                }
            }
        }

        System.out.println(result);
    }
}
