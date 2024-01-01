package com.tempdecal.leetcode.twopointers;

import java.util.List;
import java.util.Objects;

public class ValidPalindrome {

    public static boolean pointer(String s) {
        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int stringLength = cleanedString.length();
        int middle = stringLength / 2;
        for (int i = 0; i < middle; i++) {
            if (cleanedString.charAt(i) != cleanedString.charAt(stringLength - 1 - i)) return false;
        }
        return true;
    }

    public static boolean recursive(String s) {
        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return checkString(cleanedString.chars().mapToObj(c -> (char) c).toList());
    }

    public static boolean checkString(List<Character> str) {
        if (str.size() == 1 || str.isEmpty()) {
            return true;
        }
        if ((Objects.equals(str.getFirst(), str.getLast()))) {
            return checkString(str.subList(1, str.size() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(recursive(str));
        System.out.println(pointer(str));
    }
}
