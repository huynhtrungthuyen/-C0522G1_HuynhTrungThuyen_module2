package ss7_interface_abstract_class.practice.interface_comparable;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        return Double.compare(getRadius(), o.getRadius());

//        if (getRadius() > o.getRadius()) {
//            return 1;
//        }
//
//        if (getRadius() < o.getRadius()) {
//            return -1;
//        }
//
//        return 0;

    }
}
