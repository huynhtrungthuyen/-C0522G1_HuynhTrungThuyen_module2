package ss1_Introduction_to_java.exercise;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD: ");
        double usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.println("Giá trị VND: \n" + vnd);
    }
}
