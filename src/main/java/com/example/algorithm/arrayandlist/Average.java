package com.example.algorithm.arrayandlist;

import java.util.Arrays;
import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        int maxNumber = numbers[numbers.length - 1];
        double sum = 0.0D;

        for (double number: numbers) {
            sum+= (number/maxNumber)*100;
        }

        System.out.println(sum/count);
    }
}