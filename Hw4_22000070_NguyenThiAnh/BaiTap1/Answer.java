package Hw4_22000070_NguyenThiAnh.BaiTap1;

import java.util.Stack;

public class Answer {
    public static void answerQue(String hoten) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0 ) {
                s.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        System.out.print(result.reverse());
    }

    public static void main(String[] args) {
        String hoten = "NguyenThiAnh";
        answerQue(hoten);
    }
}
