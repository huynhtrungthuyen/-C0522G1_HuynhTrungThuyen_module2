package ss11_dsa_stack_queue.exercise.reverse;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StringReverse {
    public static void main(String[] args) {
        Stack<String> stringReverse = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi bất kì: ");
        String string = scanner.nextLine();

        String[] stringArr = string.split(" ");
        System.out.println(Arrays.toString(stringArr));

        for (String item : stringArr) {
            stringReverse.push(item);
        }

        string = "";
        while (!stringReverse.isEmpty()) {
            string += stringReverse.pop() + " ";
        }
        System.out.println(string);
    }
}
