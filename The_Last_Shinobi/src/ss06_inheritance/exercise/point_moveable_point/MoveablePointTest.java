package ss06_inheritance.exercise.point_moveable_point;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(1,2);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());

        MoveablePoint moveablePoint1 = new MoveablePoint(3,4,5,6);
        System.out.println(moveablePoint1);
        System.out.println(moveablePoint1.move());
        System.out.println(moveablePoint1.move());
        System.out.println(moveablePoint1.move());
        System.out.println(moveablePoint1.move());
    }
}
