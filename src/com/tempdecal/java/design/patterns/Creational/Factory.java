package com.tempdecal.java.design.patterns.Creational;

public class Factory {
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

    public static class AnimalFactory {
        public Animal getAnimal(String animalType) {
            if (animalType == null) {
                return null;
            }
            if (animalType.equalsIgnoreCase("DOG")) {
                return new Dog();
            } else if (animalType.equalsIgnoreCase("CAT")) {
                return new Cat();
            }
            return null;
        }
    }

    // Usage
    public static class FactoryDemo {
        public static void main(String[] args) {
            AnimalFactory animalFactory = new AnimalFactory();

            Animal dog = animalFactory.getAnimal("DOG");
            dog.speak();

            Animal cat = animalFactory.getAnimal("CAT");
            cat.speak();
        }
    }

}
