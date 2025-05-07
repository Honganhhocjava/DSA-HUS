package reviewMidterm.Stack;

import Hw4_22000070_NguyenThiAnh.BaiTap5.Polindrome;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Prlindrome {

    public static boolean checkpar(String s){
        Stack stack = new Stack<>();
        Queue queue = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            queue.add(s.charAt(i));
        }
        while (stack.pop()!= null) {
            if(stack.pop() != queue.remove()) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Polindrome polindrome = new Polindrome();
        String str1 = "OADCCDAO";
        String str2 = "AnhxinhxinhAn";
        System.out.print(polindrome.polindromeString(str2));
    }
}
