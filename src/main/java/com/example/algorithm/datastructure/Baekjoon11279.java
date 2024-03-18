package com.example.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baekjoon11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == 0) {
                if (queue.isEmpty()) {
                    stringBuilder.append(0).append("\n");
                } else {
                    stringBuilder.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(number);
            }
        }

        System.out.println(stringBuilder);
    }
}
