package com.tempdecal.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && i >= 3) {
                if (n % 5 == 0) {
                    answerList.add("com.tempdecal.leetcode.FizzBuzz");
                } else {
                    answerList.add("Fizz");
                }
            } else if (i % 5 == 0 && i >= 5) {
                answerList.add("Buzz");
            } else {
                answerList.add(String.valueOf(i));
            }
        }
        return answerList;
    }
    public static void main(String[] args) {
        System.out.println(fizzBuzz(4));
    }
}
