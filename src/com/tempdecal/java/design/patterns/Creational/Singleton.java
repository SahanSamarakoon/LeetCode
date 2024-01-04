package com.tempdecal.java.design.patterns.Creational;

public class Singleton {

    public static class EagerInitializedSingleton {

        private static final EagerInitializedSingleton singleton = new EagerInitializedSingleton();

        private EagerInitializedSingleton() {
        }

        public static EagerInitializedSingleton getInstance() {
            return singleton;
        }
    }

    public static class LazyInitializedSingleton {

        private static LazyInitializedSingleton singleton;

        private LazyInitializedSingleton() {
        }

        public static LazyInitializedSingleton getInstance() {
            return singleton == null ? singleton = new LazyInitializedSingleton() : singleton;
        }
    }

}
