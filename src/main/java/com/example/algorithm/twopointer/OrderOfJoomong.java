package com.example.algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OrderOfJoomong {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfMaterials = Integer.parseInt(bufferedReader.readLine());
        int completeNumber = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] materials = new int[numberOfMaterials];

        for (int i = 0; i < numberOfMaterials; i++) {
            materials[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(materials);

        int startIndex = 0;
        int endIndex = materials.length - 1;
        int count = 0;

        while (startIndex != endIndex) {
            if (materials[startIndex] + materials[endIndex] == completeNumber) {
                count++;
                startIndex++;
                endIndex--;
            } else if (materials[startIndex] + materials[endIndex] > completeNumber) {
                endIndex--;
            } else if (materials[startIndex] + materials[endIndex] < completeNumber) {
                startIndex++;
            }
        }

        System.out.println(count);
    }
}
