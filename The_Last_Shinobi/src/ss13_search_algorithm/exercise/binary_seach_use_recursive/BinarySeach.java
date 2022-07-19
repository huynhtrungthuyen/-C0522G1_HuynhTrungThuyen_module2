package ss13_search_algorithm.exercise.binary_seach_use_recursive;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySeach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("array[%d] = ", i);
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        System.out.println("Mảng sau khi sắp xếp: ");
        System.out.println(Arrays.toString(array));

        System.out.print("Nhập số cần tìm kiếm: ");
        int number = scanner.nextInt();

        System.out.println(binarySearch(array, 0, array.length - 1, number));
    }

    private static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }

        int midle = (left + right) / 2;
        if (array[midle] == value) {
            return midle;
        }

        if (array[midle] < value) {
            return binarySearch(array, midle + 1, right, value);
        }

        return binarySearch(array, left, midle - 1, value);
    }
}
