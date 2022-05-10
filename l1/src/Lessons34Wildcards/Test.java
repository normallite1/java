package Lessons34Wildcards;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Animal> ourAnimal = new ArrayList<>();
        ourAnimal.add(new Animal(1));
        ourAnimal.add(new Animal(2));

        test(ourAnimal);
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        test(dogs);

    }
    private static void test(List<? extends Animal> ourAnimals)  {
       for(Animal animal : ourAnimals) {
           animal.eat();
       }
    }
}
