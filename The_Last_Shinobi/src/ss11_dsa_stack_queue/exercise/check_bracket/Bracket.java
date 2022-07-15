package ss11_dsa_stack_queue.exercise.check_bracket;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static boolean checkBracket(String string) {
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char item = string.charAt(i);

            if (item == '(') {
                characterStack.push(item);
            }
            else
            if (item == ')') {
                if (characterStack.isEmpty()) {
                    return false;
                }

                characterStack.pop();
            }
        }

        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        String string = scanner.nextLine();
        System.out.println(checkBracket(string));
    }
}
