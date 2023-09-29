package com.example.algorithm.arrayandlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfRemainder {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] sumArray = new int[n];

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(stringTokenizer.nextToken());

            if (i == 0) sumArray[i] = data;
            else sumArray[i] = data + sumArray[i - 1];
        }

        int count = 0;

        for (int i = 0; i < sumArray.length; i++) {
            if (i == 0) {
                if (sumArray[i]%m == 0) count++;
            } else {
                for (int j = i; j >= 0; j--) {
                    if (j == i) if (sumArray[i]%m == 0) count++;
                    else if ((sumArray[i] - sumArray[j])%m == 0) count++;
                }
            }
        }

        System.out.println(count);
    }
}
