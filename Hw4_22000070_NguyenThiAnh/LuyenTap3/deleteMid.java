package Hw4_22000070_NguyenThiAnh.LuyenTap3;

import java.util.Stack;

public class deleteMid {
    public static void deleteMid(int size , Stack stack1) {
        Stack stack = new Stack();
        if(size%2==0) {
            int mid = size / 2;
            for (int i = 0; i < mid; i++) {
                stack.push( stack1.pop());
            }
            stack1.pop();
        }
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack1.isEmpty()){
            stringBuilder.append(stack1.pop()+" ");
        }
        System.out.print(stringBuilder);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        int size = 6;
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(70);

        deleteMid(6,stack);

    }
}
