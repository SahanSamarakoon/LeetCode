package com.tempdecal.leetcode.arrayhashing;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> hashmapSolution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s:strs){
            char[] charOccurrences = new char[26];
            for(char c: s.toCharArray()){
                charOccurrences[c-'a']++;
            }
            String charKey = String.valueOf(charOccurrences);
            if(!map.containsKey(charKey)){
                map.put(charKey, new ArrayList<>());
            }
            map.get(charKey).add(s);

        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(hashmapSolution(strs).toString());
    }
}
