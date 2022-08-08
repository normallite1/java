package Lessons33;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> animal1 = new ArrayList<>();
        animal1.add("Cat");
        animal1.add("Dog");
        animal1.add("Frog");

        String animal = animal1.get(1);
       System.out.println(animal);
    }
}
