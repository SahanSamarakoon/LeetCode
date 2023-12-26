package com.tempdecal.ieeextreme;

import java.util.Arrays;
import java.util.Scanner;

public class Scheduler {
    public static long solve(int n, int m, long[] jobTime) {
        long[][] dp = new long[m + 1][1 << n];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], Long.MAX_VALUE);
        int[] times = new int[1 << n];
        for (int mask = 0; mask < 1 << n; mask++) {
            int time = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    time += jobTime[i];
            }
            times[mask] = time;
        }
        dp[m][(1 << n) - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int mask = (1 << n) - 2; mask >= 0; mask--) {
                for (int curr = 1; curr < 1 << n; curr++) {
                    if ((curr & mask) == 0) {
                        long time = Math.max(times[curr], dp[i + 1][curr | mask]);
                        dp[i][mask] = Math.min(dp[i][mask], time);
                    }
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] jobTime = new long[n];
        for (int i = 0; i < n; i++) {
            jobTime[i]=(long) Math.pow(2,in.nextInt());
        }
        in.close();
        System.out.println(solve(n,m,jobTime) % 1000000007L);
    }
}
