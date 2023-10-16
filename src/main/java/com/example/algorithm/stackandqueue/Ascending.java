package com.example.algorithm.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ascending {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        bufferedReader.close();

        Stack<Integer> stack = new Stack<>();
        int integer = 0;
        boolean canMakeAscend = true;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            if (!canMakeAscend) {
                stringBuilder = new StringBuilder("NO");
                break;
            }
            int number = numbers[i];

            while (true) {
                if (stack.isEmpty()) {
                    integer++;
                    stringBuilder.append("+");
                    stack.push(integer);
                }

                if (number > stack.peek()) {
                    integer++;
                    stringBuilder.append("+");
                    stack.push(integer);
                } else if (number == stack.peek()) {
                    stringBuilder.append("-");
                    stack.pop();
                    break;
                } else {
                    canMakeAscend = false;
                    break;
                }
            }
        }

        if ("NO".contentEquals(stringBuilder)) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < stringBuilder.length(); i++) {
                System.out.println(stringBuilder.charAt(i));
            }
        }
    }
}
