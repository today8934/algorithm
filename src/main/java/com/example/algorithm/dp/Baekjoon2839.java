package com.example.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        if (n == 4 || n == 7) {
            System.out.println(-1);
        } else if (n%5 == 0) {
            System.out.println(n/5);
        } else if (n%5 == 1 || n%5 == 3) {
            System.out.println(n/5 + 1);
        } else if (n%5 == 2 || n%5 == 4) {
            System.out.println(n/5 + 2);
        }
    }
}
