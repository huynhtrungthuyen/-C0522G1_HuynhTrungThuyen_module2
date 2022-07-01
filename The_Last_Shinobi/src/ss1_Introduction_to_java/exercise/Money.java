package ss1_Introduction_to_java.exercise;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD: ");
        usd = scanner.nextDouble();
        double vnd = usd * 23000;
        System.out.println("Giá trị VND: \n" + vnd);
    }
}
