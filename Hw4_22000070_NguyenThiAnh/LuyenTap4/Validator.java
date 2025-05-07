package Hw4_22000070_NguyenThiAnh.LuyenTap4;

import java.util.Stack;

public class Validator {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Validator validator = new Validator();
        String s = "1 + {2 + (3 + 6)*5 }";
        System.out.println(validator.isValid(s));
    }
}
