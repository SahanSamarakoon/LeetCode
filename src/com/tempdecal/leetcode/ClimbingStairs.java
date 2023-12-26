package com.tempdecal.leetcode;

public class ClimbingStairs {
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

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(0));
    }
}
