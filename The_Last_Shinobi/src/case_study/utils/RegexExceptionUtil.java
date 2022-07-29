package case_study.utils;

import case_study.exception.AgeInvalidException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegexExceptionUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static boolean isLeapYear(int year) {
        boolean isDivisible4 = year % 4 == 0;
        boolean isDivisible100 = year % 100 == 0;
        boolean isDivisible400 = year % 400 == 0;

        return (isDivisible4 && !isDivisible100) || isDivisible400;
    }

    public static String getDateOfBirth() {
        String dateOfBirth;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        double age;
        while (true) {
            try {
                System.out.print("Nhập ngày sinh khách hàng: ");
                dateOfBirth = SCANNER.nextLine();
                if (!dateOfBirth.matches("(0[1-9]|[12]\\d|3[0-1])/(0[1-9]|1[0-2])/(19\\d{2}|20[01]\\d)")) {
                    throw new AgeInvalidException("Vui lòng nhập đúng định dạng dd/mm/yyyy!");
                }

                String[] str = dateOfBirth.split("/");
                if (str[1].equals("04") || str[1].equals("06") || str[1].equals("09") || str[1].equals("11")) {
                    if (Integer.parseInt(str[0]) > 30) {
                        throw new AgeInvalidException("Vui lòng nhập đúng số ngày trong tháng (tháng này có tối đa 30 ngày)!");
                    }
                } else if (str[1].equals("02")) {
                    if (isLeapYear(Integer.parseInt(str[2]))) {
                        if (Integer.parseInt(str[0]) > 29) {
                            throw new AgeInvalidException("Vui lòng nhập đúng số ngày trong tháng (tháng 2 có tối đa 29 ngày vì là năm nhuận)!");
                        }
                    } else {
                        if (Integer.parseInt(str[0]) > 28) {
                            throw new AgeInvalidException("Vui lòng nhập đúng số ngày trong tháng (tháng 2 có tối đa 28 ngày)!");
                        }
                    }
                }

                age = (double) (date.getTime() - dateFormat.parse(dateOfBirth).getTime())/315576E5;
                if (age < 18 || age > 100) {
                    throw new AgeInvalidException("Ngày sinh phải nhỏ hơn ngày hiện tại 18 năm và người dùng không được quá 100 tuổi!");
                }

                return dateOfBirth;

            } catch (AgeInvalidException e) {
                System.out.println(e.getMessage());
            } catch (ParseException e) {
                e.getStackTrace();
            }
        }
    }
}
