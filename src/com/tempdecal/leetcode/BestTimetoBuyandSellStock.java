package com.tempdecal.leetcode;

public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int localMinPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<localMinPrice) localMinPrice=prices[i];
            if (prices[i]-localMinPrice>maxProfit) maxProfit=prices[i]-localMinPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
