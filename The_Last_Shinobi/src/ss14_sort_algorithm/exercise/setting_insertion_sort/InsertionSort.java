package ss14_sort_algorithm.exercise.setting_insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args) {
        System.out.println("Mảng trước khi sắp xếp:\n" + Arrays.toString(list));
        System.out.println("Mảng sau khi sắp xếp:\n" + Arrays.toString(insertionSort(list)));
    }

    private static int[] insertionSort(int[] array) {
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

        return array;
    }
}
