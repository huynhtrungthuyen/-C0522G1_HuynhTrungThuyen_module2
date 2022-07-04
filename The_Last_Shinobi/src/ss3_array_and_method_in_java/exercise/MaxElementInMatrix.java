package ss3_array_and_method_in_java.exercise;

import java.util.Scanner;

public class MaxElementInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng: ");
        int row = scanner.nextInt();
        System.out.println("Nhập số cột: ");
        int col = scanner.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập matrix[%d][%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }

        int max = matrix[0][0];
        System.out.println("Ma trận vừa tạo: ");
        for (int[] rowMatrix : matrix) {
            for (int colMatrix : rowMatrix) {
                System.out.print(colMatrix + " ");
                if (colMatrix > max) {
                    max = colMatrix;
                }
            }
            System.out.println();
        }

        System.out.println("Phần tử lớn nhất trong ma trận: ");
        System.out.println(max);
    }
}
