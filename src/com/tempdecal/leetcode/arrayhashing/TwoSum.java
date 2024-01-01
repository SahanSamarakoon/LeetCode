package com.tempdecal.leetcode.arrayhashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] sortedArray = nums.clone();
        Arrays.sort(sortedArray);
        int minIndex = 0;
        int maxIndex = nums.length-1;
        int[] outputList = new int[2];
        while (true) {
            if (sortedArray[minIndex] + sortedArray[maxIndex] == target) {
                outputList[0] = findIndex(nums,sortedArray[minIndex] );
                outputList[1] = sortedArray[minIndex]==sortedArray[maxIndex] ? outputList[0]+1 :findIndex(nums,sortedArray[maxIndex] );
                break;
            } else if (sortedArray[minIndex] + sortedArray[maxIndex] > target) {
                maxIndex -= 1;
            } else {
                minIndex += 1;
            }
        }
        return outputList;
    }

    public static int findIndex(int[] arr, int t) {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                return new int[] {i, hashMap.get(target-nums[i])};
            }else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4,5,8,7,1};
        int[] ans = twoSumHashMap(nums,13);
        assert ans != null;
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
