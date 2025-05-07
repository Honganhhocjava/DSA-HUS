package Hw4_22000070_NguyenThiAnh.Baitap3;

import java.util.Stack;

//Sử dụng stack viết chương trình xét tính hợp lệ về dấu ngoặc của biểu thức:
public class BracketValidator {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i)=='[')  {
                stack.push(str.charAt(i));
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i)==']') {
                if( stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        BracketValidator bracketValidator = new BracketValidator();
        String str = "1 + {2 + (3 + 6)*5 }";
        System.out.println( bracketValidator.isValid(str));
    }
}
