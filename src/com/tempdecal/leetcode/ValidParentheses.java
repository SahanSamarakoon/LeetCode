package com.tempdecal.leetcode;

import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static boolean validate(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (stack.isEmpty()){
                if (c==(')') || c==('}') || c==(']')) return false;
                stack.push(c);
            }
            else{
                char topChar = stack.peek();
                if (topChar=='(' && c==')') stack.pop();
                else if (topChar=='[' && c==']') stack.pop();
                else if (topChar=='{' && c=='}') stack.pop();
                else stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[{}";
        System.out.println(validate(s));
    }
}
