package com.tempdecal.java.design.patterns.Creational;

public class Prototype {
    public static class Person implements Cloneable {
        private String name;
        private String address;

        public Person(String name, String address) {
            this.name = name;
            this.address = address;
        }

        @Override
        public Person clone() throws CloneNotSupportedException {
            return (Person) super.clone();
        }
    }
}
