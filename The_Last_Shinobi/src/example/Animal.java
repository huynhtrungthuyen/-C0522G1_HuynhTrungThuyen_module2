package example;

import java.util.Comparator;
import java.util.Objects;

public class Animal implements Comparator<Animal> {
    private int id;
    private String name;

    public Animal() {
    }

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Animal o) {
//        return getName().compareTo(o.getName());
//    }

    @Override
    public int compare(Animal o1, Animal o2) {
        return Double.compare(o1.getId(), o2.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id && name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
