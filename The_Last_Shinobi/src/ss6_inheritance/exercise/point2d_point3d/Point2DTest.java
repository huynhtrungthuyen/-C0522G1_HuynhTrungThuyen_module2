package ss6_inheritance.exercise.point2d_point3d;

import java.util.Arrays;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println("Array of {x,y} = " + Arrays.toString(point2D.getXY()));
        System.out.printf("(%s)", point2D);

        point2D = new Point2D(1, 2);
        System.out.println("\nArray of {x,y} = " + Arrays.toString(point2D.getXY()));
        System.out.printf("(%s)", point2D);

        point2D.setXY(3, 4);
        System.out.println("\nArray of {x,y} = " + Arrays.toString(point2D.getXY()));
        System.out.printf("(%s)", point2D);
    }
}
