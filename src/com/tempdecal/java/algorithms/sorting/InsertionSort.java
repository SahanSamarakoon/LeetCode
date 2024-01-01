package com.tempdecal.java.algorithms.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        int[] sortedArr = insertionSort(arr);
        for (int i : sortedArr) {
            System.out.println(i);
        }
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                int swap = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = swap;
                j--;
            }
        }
        return arr;
    }
}
