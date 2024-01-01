package com.tempdecal.leetcode.arrayhashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static boolean solution(int[] nums) {
        Set<Integer> targetSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length != targetSet.size();
    }

    public static boolean hashsetSolution(int[] nums) {
        HashSet<Integer> hSet = new HashSet<>();
        for (int num : nums) {
            if (hSet.contains(num)) {
                return true;
            }
            hSet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution(nums));
        System.out.println(hashsetSolution(nums));
    }
}
