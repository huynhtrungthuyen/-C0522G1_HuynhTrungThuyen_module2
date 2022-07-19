package ss02_loop_in_java.practice;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên bất kì: ");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.println(number + " không phải là số nguyên tố!");
        } else {
            int index = 2;
            boolean check = true;
            while (index <= Math.sqrt(number)) {
                if (number % index == 0) {
                    check = false;
                    break;
                }
                index++;
            }
            if (check) {
                System.out.println(number + " là số nguyên tố!");
            } else {
                System.out.println(number + " không phải là số nguyên tố!");
            }
        }
    }
}
