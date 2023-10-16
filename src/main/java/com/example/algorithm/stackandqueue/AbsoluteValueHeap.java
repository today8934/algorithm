package com.example.algorithm.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteValueHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });

        for (int i = 0; i < count; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());

            if (n == 0) {
                if (heap.isEmpty()) System.out.println(0);
                else System.out.println(heap.poll());
            } else {
                heap.offer(n);
            }
        }
    }
}
