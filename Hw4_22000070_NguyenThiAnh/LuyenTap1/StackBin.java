package Hw4_22000070_NguyenThiAnh.LuyenTap1;

import java.util.Scanner;
import java.util.Stack;


// Nhập vào một số nguyên dương n.
// Hãy chuyển n thành mã nhị phân và in chuỗi đó ra màn hình.

public class StackBin {
    public static void stackBin(int n ){
        Stack stack = new Stack<>();
        while (n > 0) {
            stack.push(n%2);
            n = n/2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        System.out.print(stringBuilder);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        System.out.print("Sau khi chuyen n thanh ma nhi phan: ");
        stackBin(n);
    }
}
