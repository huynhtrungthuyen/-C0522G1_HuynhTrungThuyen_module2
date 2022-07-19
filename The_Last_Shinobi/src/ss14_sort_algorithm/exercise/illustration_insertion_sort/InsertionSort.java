package ss14_sort_algorithm.exercise.illustration_insertion_sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("array[%d] = ", i);
            array[i] = scanner.nextInt();
        }

        System.out.println("Mảng số nguyên vừa tạo:\n" + Arrays.toString(array));

        int value;
        int index;
        for (int i = 1; i < array.length; i++) {
            value = array[i];
            index = i;

            while (index > 0 && value < array[index - 1]) {
                array[index] = array[index - 1];
                index--;
            }

            array[index] = value;
        }

        System.out.println("Mảng sau khi sắp xếp:\n" + Arrays.toString(array));
    }
}
