package com.example.algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DnaPassword {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int dnaLength = Integer.parseInt(stringTokenizer.nextToken());
        int passwordLength = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String dnaString = stringTokenizer.nextToken();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] acgt = new int[4];
        int[] checkArr = new int[4];
        checkArr[0] = 0;
        checkArr[1] = 0;
        checkArr[2] = 0;
        checkArr[3] = 0;

        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder passwordString = new StringBuilder(dnaString.substring(0, passwordLength));

        for (int i = 0; i< passwordLength; i++) {
            switch (passwordString.charAt(i)) {
                case 'A': checkArr[0] = checkArr[0] + 1; break;
                case 'C': checkArr[1] = checkArr[1] + 1; break;
                case 'G': checkArr[2] = checkArr[2] + 1; break;
                case 'T': checkArr[3] = checkArr[3] + 1; break;
            }
        }

        int result = 0;

        if (checkArr[0] >= acgt[0] && checkArr[1] >= acgt[1] && checkArr[2] >= acgt[2] && checkArr[3] >= acgt[3]) result++;

        for (int i = 1; i <= dnaLength - passwordLength; i++) {
            switch(dnaString.charAt(i - 1)) {
                case 'A': checkArr[0] = checkArr[0] - 1; break;
                case 'C': checkArr[1] = checkArr[1] - 1; break;
                case 'G': checkArr[2] = checkArr[2] - 1; break;
                case 'T': checkArr[3] = checkArr[3] - 1; break;
            }

            switch(dnaString.charAt(i + passwordLength - 1)) {
                case 'A': checkArr[0] = checkArr[0] + 1; break;
                case 'C': checkArr[1] = checkArr[1] + 1; break;
                case 'G': checkArr[2] = checkArr[2] + 1; break;
                case 'T': checkArr[3] = checkArr[3] + 1; break;
            }

            if (checkArr[0] >= acgt[0] && checkArr[1] >= acgt[1] && checkArr[2] >= acgt[2] && checkArr[3] >= acgt[3]) result++;
        }

        System.out.println(result);
    }
}
