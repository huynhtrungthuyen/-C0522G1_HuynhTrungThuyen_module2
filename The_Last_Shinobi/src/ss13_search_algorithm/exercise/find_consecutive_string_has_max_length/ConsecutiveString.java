package ss13_search_algorithm.exercise.find_consecutive_string_has_max_length;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsecutiveString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi bất kì: ");
        String string = scanner.nextLine();

        List<Character> maxString = new ArrayList<>();
        List<Character> tempString = new ArrayList<>();

        tempString.add(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) <= string.charAt(i - 1)) {
                tempString.clear();
            }

            tempString.add(string.charAt(i));

            if (tempString.size() > maxString.size()) {
                maxString.clear();
                maxString.addAll(tempString);
            }
        }

        System.out.println("Chuỗi liên tiếp có độ dài lớn nhất: ");
        for (Character character : maxString) {
            System.out.print(character);
        }
    }
}
