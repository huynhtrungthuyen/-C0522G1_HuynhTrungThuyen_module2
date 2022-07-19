package ss02_loop_in_java.exercise;

import java.util.Scanner;

public class First20Primes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số lượng số lượng số nguyên tố cần in ra: ");
        int number = scanner.nextInt();
        int count = 0;
        int prime = 2;
        while (count < number) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(prime); i++) {
                if (prime % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(prime + ", ");
                count++;
            }
            prime++;
        }
    }
}
