package ss3_array_and_method_in_java.exercise;

import java.util.Scanner;

public class SumDiagonalMatrixSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng của Ma trận vuông: ");
        int size = scanner.nextInt();
        double[][] matrixSquare = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("matrixSquare[%d][%d]", i, j);
                matrixSquare[i][j] = scanner.nextDouble();
            }
        }

        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrixSquare[i][i];
        }
        System.out.println("Tổng các số ở đường chéo chính của ma trận vuông là: " + sum);
    }
}
