package com.tempdecal.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];
        for (int[] row : array)
            Arrays.fill(row, 0);
        array[m-1][n-1]=1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 ){
                    if (j != n - 1) array[i][j] =  1;
                }
                else if (j == n - 1) array[i][j] = 1;
                else {
                    array[i][j] = array[i][j + 1] + array[i + 1][j] ;
                }
            }
        }
        return array[0][0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int n = in.nextInt();
        in.close();
        System.out.println(uniquePaths(c, n));
    }
}
