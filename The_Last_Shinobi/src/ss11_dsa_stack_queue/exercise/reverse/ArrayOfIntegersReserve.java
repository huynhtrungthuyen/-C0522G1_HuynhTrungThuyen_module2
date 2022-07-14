package ss11_dsa_stack_queue.exercise.reverse;

import java.util.Scanner;
import java.util.Stack;

public class ArrayOfIntegersReserve {
    public static void main(String[] args) {
        Stack<Integer> array = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số phần tử của mảng: ");
        int length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            System.out.printf("array[%d] = ", i);
            array.push(scanner.nextInt());
        }

        System.out.println("Trước khi đảo ngược: array = " + array);

        Stack<Integer> arrayReverse = new Stack<>();

        for (int item : array) {
            arrayReverse.push(item);
        }

        for (int i = 0; i < array.size(); i++) {
            array.set(i, arrayReverse.pop());
        }

        System.out.println("Sau khi đảo ngược: array = " + array);
    }
}
