package com.tempdecal.ieeextreme;

import java.util.Arrays;
import java.util.Scanner;

public class BeetleBag {
    public static int solve(int c, int n, Scanner in) {
        int[] power = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i]=in.nextInt();
            power[i]=in.nextInt();
        }
        int[][] array = new int[n][c];
        for (int[] row : array)
            Arrays.fill(row, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                if (i==0) {
                    if ((j+1)>=weight[i]) array[i][j]=power[i];
                }
                else if ((j+1)>=weight[i]) {
                    if (j+1>weight[i]) array[i][j]=Math.max(power[i]+array[i-1][j-weight[i]],array[i-1][j]);
                    else array[i][j]=Math.max(power[i],array[i-1][j]);
                }
                else array[i][j] = array[i-1][j];
            }
        }
        return array[n-1][c-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int c = in.nextInt();
            int n = in.nextInt();
            System.out.println(solve(c,n, in));
        }
        in.close();
    }
}
