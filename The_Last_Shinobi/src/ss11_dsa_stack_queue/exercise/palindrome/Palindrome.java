package ss11_dsa_stack_queue.exercise.palindrome;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        Queue<String> stringQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi bất kì: ");
        String string = scanner.nextLine();

        String[] stringArr = string.split("");
        System.out.println(Arrays.toString(stringArr));

        for (String str : stringArr) {
            stringStack.push(str.toLowerCase());
            stringQueue.add(str.toLowerCase());
        }

        String str1 = "";
        String str2 = "";

        while (!stringStack.isEmpty() && !stringQueue.isEmpty()) {
            str1 += stringStack.pop();
            str2 += stringQueue.poll();
        }

        if (str1.equals(str2)) {
            System.out.println("Chuỗi vừa nhập là Palindrome!");
        }
        else {
            System.out.println("Chuỗi vừa nhập không phải là Palindrome!");
        }
    }
}
