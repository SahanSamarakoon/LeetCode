package com.tempdecal.ieeextreme;

import java.util.Scanner;

public class RunningUpStairs {
    public static int climbStairs(int n) {
        if (n<=0) return 0;
        int[] array = new int[n+1];
        array[n]=1;
        array[n-1]=1;
        int i =n-2;
        while(i>=0){
            array[i] = array[i+1]+array[i+2];
            i--;
        }
        return array[0];
    }

    public static int climbStairsFib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int numSteps = in.nextInt();
            System.out.println(climbStairsFib(numSteps));
        }
        in.close();
    }
}
