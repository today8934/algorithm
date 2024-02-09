package com.example.algorithm.sort;

public class QuickSort {
    private static final int[] arr = { 3, 1, 5, 6, 20, 10, 7, 11, 15, 9 };

    public static void main(String[] args) {
        quickSort(0, arr.length - 1);

        for (int i: arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int pivot, int end) {
        if (pivot >= end) return;

        int left = pivot + 1;
        int right = end;

        while (right >= left) {
            while (left <= end && arr[left] < arr[pivot]) left++;
            while (right > pivot && arr[right] > arr[pivot]) right--;

            if (left > right) swap(pivot, right);
            else swap(left, right);
        }

        quickSort(pivot, right - 1);
        quickSort(right + 1, end);
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
