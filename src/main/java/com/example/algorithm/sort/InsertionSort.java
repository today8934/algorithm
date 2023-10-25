package com.example.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        int count = Integer.parseInt(bufferedReader.readLine());

        int[] array = new int[count];
        String[] numbers = bufferedReader.readLine().split(" ");

        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        for (int i = 1; i < count; i++) {
            int insertIdx = i;
            int insertValue = array[i];

            for (int j = i - 1; j >= 0; j--) {
                if (insertValue <= array[j]) insertIdx = j;
            }

            for (int j = i; j > insertIdx; j--) {
                array[j] = array[j - 1];
            }

            array[insertIdx] = insertValue;
        }

        int[] sumArray = new int[5];
        sumArray[0] = array[0];
        for (int i = 1; i < sumArray.length; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        int sum = Arrays.stream(sumArray).sum();
        System.out.println(sum);
    }
}
