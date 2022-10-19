package com.tempdecal.leetcode;

import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for ( int[] banks : accounts){
            int wealth = Arrays.stream(banks).sum();
            if ((max < wealth)) {
                max = wealth;
            }
        }
        return max;
    }
}
