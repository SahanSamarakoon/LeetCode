package com.tempdecal.java.quirks;

public class PassByValue {
    public static void main(String[] args) {
        var s = "Hello";
        test(s);
        //Should print "World" if Java is pass by reference.
        //But instead it prints "Hello" because java is pass by value
        System.out.println(s);
    }

    public static void test(String s) {
        s = "World";
    }

}
