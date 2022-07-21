package ss15_exception_debug.exercise.controller;

import ss15_exception_debug.exercise.model.Triangle;
import ss15_exception_debug.exercise.model.IllegalRightTriangleException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double firstEdge;
        double secondEdge;
        double thirdEdge;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập cạnh thứ nhất: ");
                firstEdge = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập cạnh thứ hai: ");
                secondEdge = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập cạnh thứ ba: ");
                thirdEdge = Double.parseDouble(scanner.nextLine());
                Triangle triangle = new Triangle(firstEdge, secondEdge, thirdEdge);
                System.out.println(triangle);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập số!");
            }
            catch (IllegalRightTriangleException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập đúng giá trị các cạnh của tam giác!");
            }
        }
    }
}
