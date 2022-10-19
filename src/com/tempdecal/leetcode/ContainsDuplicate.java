package com.tempdecal.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static boolean solution(int[] nums) {
        Set<Integer> targetSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length == targetSet.size() ? false : true;
    }

    public static boolean hashsetSolution(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hSet.contains(nums[i])) {
                return true;
            }
            hSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution(nums));
        System.out.println(hashsetSolution(nums));
    }
}
