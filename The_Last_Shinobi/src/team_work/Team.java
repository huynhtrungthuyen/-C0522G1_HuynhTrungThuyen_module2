package team_work;

public class Team {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j == 6 - i || j == 5 + i) {
                    System.out.print(i);
                } else if (j == i - 4 || j == 15 - i) {
                    System.out.print(10 - i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
