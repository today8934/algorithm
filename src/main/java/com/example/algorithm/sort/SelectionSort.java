package com.example.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        int[] array = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            array[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        for (int i = 0; i < input.length(); i++) {
            int maxIdx = i;

            for (int j = i; j < input.length(); j++) {
                if (array[j] > array[maxIdx]) maxIdx = j;
            }

            if (array[maxIdx] > array[i]) {
                int tmp = array[i];
                array[i] = array[maxIdx];
                array[maxIdx] = tmp;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }

        System.out.println(stringBuilder);
    }
}
