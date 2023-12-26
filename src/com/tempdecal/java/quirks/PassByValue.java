package com.tempdecal.java.quirks;

public class PassByValue {
    public static void main (String[] args) {
        var s = "Hello";
        test(s);
        //Should print "Hello" if Java is pass by reference. But instead it prints "World"
        System.out.println(s);
    }

    public static void test(String s) {
        s = "World";
    }

}
