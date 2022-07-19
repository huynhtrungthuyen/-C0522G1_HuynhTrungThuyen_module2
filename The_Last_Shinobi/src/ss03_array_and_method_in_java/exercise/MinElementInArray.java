package ss03_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MinElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("array[%d] = ", i);
            array[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa tạo: ");
        System.out.println(Arrays.toString(array));

        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng: " + min);
    }
}
