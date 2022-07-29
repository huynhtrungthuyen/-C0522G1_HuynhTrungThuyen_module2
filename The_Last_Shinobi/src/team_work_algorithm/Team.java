package team_work_algorithm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Team {
    public static void main(String[] args) throws ParseException {
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
        String dateOfBirth = "28/07/2021";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        double age;
        age = (double) (date.getTime() - dateFormat.parse(dateOfBirth).getTime())/315576E5;
        System.out.println(dateFormat.parse(dateOfBirth).getTime());
        System.out.println(date.getTime());
        System.out.println(age);
    }
}
