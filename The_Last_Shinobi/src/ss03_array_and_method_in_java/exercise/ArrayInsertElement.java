package ss03_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInsertElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("Nhập array[%d]: ", i);
            array[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa tạo: ");
        System.out.println(Arrays.toString(array));

        System.out.println("Nhập phần tử cần chèn vào mảng: ");
        int number = scanner.nextInt();
        System.out.println("Nhập vị trí cần chèn: ");
        int index = scanner.nextInt();

        for (int i = array.length - 1; i > index; i--) {
            int temp = array[i - 1];
            array[i - 1] = array[i];
            array[i] = temp;
        }
        array[index] = number;
        System.out.println("Mảng sau khi chèn phần tử: ");
        System.out.println(Arrays.toString(array));
    }
}
