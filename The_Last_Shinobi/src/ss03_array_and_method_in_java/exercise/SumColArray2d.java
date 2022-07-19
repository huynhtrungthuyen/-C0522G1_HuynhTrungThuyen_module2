package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class SumColArray2d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng: ");
        int row = scanner.nextInt();
        System.out.println("Nhập số cột: ");
        int col = scanner.nextInt();
        double[][] array2d = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập matrix[%d][%d]: ", i, j);
                array2d[i][j] = scanner.nextDouble();
            }
        }

        int indexCol;
        boolean isNotIndexCol;
        do {
            System.out.println("Nhập cột cần tính tổng: ");
            indexCol = scanner.nextInt();
            isNotIndexCol = indexCol < 0 || indexCol > col - 1;
            if (isNotIndexCol) {
                System.out.println("Nhập lại cột cần tính tổng: ");
            }
        } while (isNotIndexCol);

        double sum = 0;
        System.out.println("Các phần tử trong cột cần tính tổng: ");
        for (double[] element : array2d) {
            System.out.println(element[indexCol]);
            sum += element[indexCol];
        }
        System.out.printf("Tổng các phần tử trong cột %d là:%10.2f", indexCol, sum);
    }
}
