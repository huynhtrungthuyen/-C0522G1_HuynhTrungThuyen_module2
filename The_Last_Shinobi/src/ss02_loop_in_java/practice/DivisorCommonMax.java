package ss02_loop_in_java.practice;

import java.util.Scanner;

public class DivisorCommonMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Nhập số thứ hai: ");
        int secondNumber = scanner.nextInt();
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        if (firstNumber == 0 || secondNumber == 0) {
            System.out.println("Không có ước chung!");
        }
        else {
            while (firstNumber != secondNumber) {
                if (firstNumber > secondNumber) {
                    firstNumber = firstNumber - secondNumber;
                }
                else {
                    secondNumber = secondNumber - firstNumber;
                }
            }
            System.out.println("Ước chung lớn nhất là " + firstNumber);
        }
    }
}
