package ss06_inheritance.exercise.circle_cylinder;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(2, "red");
        System.out.println(circle);
    }
}
