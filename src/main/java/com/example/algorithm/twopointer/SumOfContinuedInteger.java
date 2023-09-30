package com.example.algorithm.twopointer;

import java.util.Scanner;

public class SumOfContinuedInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while (endIndex != number) {
            if (sum > number) {
                startIndex++;
                endIndex = startIndex;
                sum = startIndex;
            } else if (sum == number) {
                count++;
                startIndex++;
                endIndex = startIndex;
                sum = startIndex;
            } else {
                endIndex++;
                sum+=endIndex;
            }
        }

        System.out.println(count);
    }
}
