package Hw3_22000070_NguyenThiAnh.BaiTap5;

import java.util.Scanner;

// De bai: Nhập vào một số nguyên dương n, tiếp theo là n số nguyên của một dãy số,
// hãy cài đặt nó vào một danh sách liên kết đơn. Tiếp theo nhập hai số nguyên k và x, (0 ≤ k ≤ n),
// hãy chèn giá trị x vào danh sách liên kết tại chỉ số k và in ra màn hình danh sách đó,
// sau một phần tử có một khoảng trắng.

public class LinkedList_1 {
    public class Node {
        Node next;
        int data;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0 ;

    public void addTop(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(top == null) {
            top = newNode;
            bot = newNode;
            return;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(top == null) {
            top = newNode;
            bot = newNode;
            return;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public void addAt(int i , int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(top == null) {
            top = newNode;
            bot = newNode;
            return;
        }
        if(i== 0) {
            newNode.next = top;
            top = newNode;
            return;
        }
        if(i == (n - 1)) {
            bot.next = newNode;
            bot = newNode;
            return;
        } else {
            Node currentNode = top;
            for (int j = 0; j < i - 1; j++) {
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        n++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen nguyen duong n : ");
        int n = sc.nextInt();
        LinkedList_1 linkedList1 = new LinkedList_1();
        System.out.print("Nhap n so nguyen vao danh sach: ");
        for (int i = 0; i < n; i++) {
            linkedList1.addBot(sc.nextInt());
        }
        System.out.print("Danh sach phan tu la: ");
        Node currentNode = linkedList1.top;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.print("Nhap gia tri phan tu muon them: ");
        int x = sc.nextInt();
        System.out.print("Nhap vi tri muon them phan tu: ");
        int k = sc.nextInt();

        linkedList1.addAt(k,x);

        System.out.print("Danh sach sau khi them phan tu la: ");
        Node currentNode1 = linkedList1.top;
        while (currentNode1 != null) {
            System.out.print(currentNode1.data + " ");
            currentNode1 = currentNode1.next;
        }



    }

}
