package ss03_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Nhập array[%d]: ", i);
            array[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa tạo: ");
        System.out.println(Arrays.toString(array));
        int[] newArray = new int[length + 1];


        System.out.println("Nhập phần tử cần chèn vào mảng: ");
        int number = scanner.nextInt();
        System.out.println("Nhập vị trí cần chèn: ");
        int index = scanner.nextInt();
        if (index < 0 || index > array.length) {
            System.out.println("không chèn được phần tử vào mảng!");
        } else {
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }

            newArray[index] = number;

            for (int i = index + 1; i < newArray.length; i++) {
                newArray[i] = array[i - 1];
            }
            array = newArray;
            System.out.println("Mảng sau khi chèn: ");
            System.out.println(Arrays.toString(array));
        }
    }
}
