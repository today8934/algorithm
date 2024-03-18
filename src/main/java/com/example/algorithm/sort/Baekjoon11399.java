package com.example.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        String[] line = bufferedReader.readLine().split(" ");
        int[] numbers = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        for (int i = 1; i < count; i++) {
            numbers[i] = numbers[i - 1] + numbers[i];
        }

        System.out.println(Arrays.stream(numbers).sum());
    }
}
