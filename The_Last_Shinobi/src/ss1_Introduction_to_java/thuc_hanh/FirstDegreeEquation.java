package ss1_Introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double numberA = scanner.nextDouble();
        System.out.println("b: ");
        double numberB = scanner.nextDouble();
        System.out.println("c: ");
        double numberC = scanner.nextDouble();

        if (numberA != 0) {
            double result = (numberC - numberB) / numberA;
            System.out.println("Equation pass with x = " + result);
        } else {
            if (numberB == numberC) {
                System.out.println("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
