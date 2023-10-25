package com.example.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[count];

        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int swapCount = 0;

            for (int j = 0; j < i; j++) {
                int tmp;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapCount++;
                }
            }

            if (swapCount == 0) break;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
