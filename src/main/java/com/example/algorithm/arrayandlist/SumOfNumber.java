package com.example.algorithm.arrayandlist;

import java.util.Scanner;

public class SumOfNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        String numberInput = scanner.next();
        char[] inputArray = numberInput.toCharArray();
        int sum = 0;

        for (char c: inputArray) {
            sum+= Integer.parseInt(String.valueOf(c));
        }

        System.out.println(sum);
    }
}
