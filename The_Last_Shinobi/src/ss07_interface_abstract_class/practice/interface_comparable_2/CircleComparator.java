package ss07_interface_abstract_class.practice.interface_comparable_2;

import ss07_interface_abstract_class.practice.interface_comparable.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        return Double.compare(c1.getRadius(), c2.getRadius());
    }
}
