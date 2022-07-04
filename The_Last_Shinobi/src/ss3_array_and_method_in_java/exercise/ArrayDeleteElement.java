package ss3_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Nhập array[%d]: ", i);
            array[i] = scanner.nextInt();
        }
        System.out.println("Mảng vừa tạo: ");
        System.out.println(Arrays.toString(array));

        System.out.println("Nhập phần tử X cần xóa: ");
        int number = scanner.nextInt();
        boolean notInArray = true;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                notInArray = false;
                for (int j = i; j < array.length - 1; j++) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                array[array.length - 1] = 0;
            }
        }
        if (notInArray) {
            System.out.println("Không tìm thấy X trong mảng!");
        } else {
            System.out.println("Mảng sau khi xóa phần tử X: ");
            System.out.println(Arrays.toString(array));
        }
    }
}
