package com.example.algorithm.test;

public class Test4 {

    public static void main(String[] args) {
        int n = 1000000000;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(i);
            if (i != n) sb.delete(0, 1);
        }

        System.out.println(sb.charAt(0));
    }
}
