package Hw4_22000070_NguyenThiAnh.BaiTap5;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class Polindrome<E> {
    public boolean polindromeString(String str) {
        Stack stack = new Stack<>();
        Queue queue = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            if(stack.pop() != queue.remove()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Polindrome polindrome = new Polindrome();
        String str = "OADCCDAO";
        System.out.print(polindrome.polindromeString(str));
    }
}
