package com.tempdecal.java.algorithms.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        int[] sortedArr = bubbleSort(arr);
        for (int i : sortedArr) {
            System.out.println(i);
        }
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;
                }
            }
        }
        return arr;
    }
}
