package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalTest {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Animal dog = new Animal(15, "dog");
        Animal cat = new Animal(11, "cat");
        Animal fish = new Animal(2, "fish");
        Animal chicken = new Animal(9, "chicken");

        animals.add(dog);
        animals.add(cat);
        animals.add(fish);
        animals.add(chicken);

//        students.sort(new Student());

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
