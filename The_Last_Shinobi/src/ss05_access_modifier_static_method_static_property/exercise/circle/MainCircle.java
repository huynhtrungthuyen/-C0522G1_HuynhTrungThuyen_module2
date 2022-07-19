package ss05_access_modifier_static_method_static_property.exercise.circle;

public class MainCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("CIRCLE 1:\n" + circle1);

        Circle circle2 = new Circle(2, "blue");
        System.out.println("CIRCLE 2:\n" + circle2);
    }
}
