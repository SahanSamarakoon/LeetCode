package com.tempdecal.leetcode;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Test {

    static long res = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BigInteger[] jobTime = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            jobTime[i] = new BigInteger("2").pow(num);
        }
        in.close();
//        System.out.println(minimumTimeRequired(jobTime, m) % 1000000007L);
    }


    public static long minimumTimeRequired(long[] jobs, int k) {
        Arrays.sort(jobs);
        dfs(jobs, jobs.length - 1, new long[k]);
        return res;
    }

    private static void dfs(long[] jobs, int pos, long[] sum) {
        if (pos < 0) {
            res = Math.min(res, Arrays.stream(sum).max().getAsLong());
            return;
        }
        if (Arrays.stream(sum).max().getAsLong() >= res) return;
        for (int i = 0; i < sum.length; i++) {
            if (i > 0 && sum[i] == sum[i - 1]) continue;
            sum[i] += jobs[pos];
            dfs(jobs, pos - 1, sum);
            sum[i] -= jobs[pos];
        }
    }
}