package com.tempdecal.java.design.patterns.Creational;

public class AbstractFactory {
    public interface Animal {
        void speak();
    }

    public static class Dog implements Animal {
        @Override
        public void speak() {
            System.out.println("Bark!");
        }
    }

    public static class Cat implements Animal {
        @Override
        public void speak() {
            System.out.println("Meow!");
        }
    }

    public static interface AnimalFactory {
        Animal createAnimal();
    }

    public static class DogFactory implements AnimalFactory {
        @Override
        public Animal createAnimal() {
            return new Dog();
        }
    }

    public static class CatFactory implements AnimalFactory {
        @Override
        public Animal createAnimal() {
            return new Cat();
        }
    }

    // Usage
    public static class AbstractFactoryDemo {
        public static void main(String[] args) {
            AnimalFactory dogFactory = new DogFactory();
            Animal dog = dogFactory.createAnimal();
            dog.speak();

            AnimalFactory catFactory = new CatFactory();
            Animal cat = catFactory.createAnimal();
            cat.speak();
        }
    }

}
