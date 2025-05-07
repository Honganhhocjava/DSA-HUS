package Hw3_22000070_NguyenThiAnh.BaiTap5;
import java.util.Scanner;

//De bai :Nhập vào một số nguyên dương n, tiếp theo là n số nguyên của một dãy số,
// hãy cài đặt nó vào một danh sách liên kết đơn, tiếp theo nhập số nguyên k (0 ≤ k < n).
//Hãy đưa ra giá trị phần tử ở chỉ số k.

public class LinkedList_2 {
    public class Node {
        Node next;
        int data;
    }
    private Node top;
    private Node bot ;
    private int n = 0;

    public int get(int i) {
        if(i <0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node cuNode = top;
        for (int j = 0; j < i ; j++) {
            cuNode = cuNode.next;
        }
        return cuNode.data;
    }

    public void addBot(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (top == null) {
            top = newNode;
            bot = newNode;
            return;
        }else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }


    public static void main(String[] args) {
        LinkedList_2 linkedList2 = new LinkedList_2();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        System.out.print("Nhap cac phan tu cua danh sach: ");
        for (int i = 0; i < n; i++) {
            linkedList2.addBot(sc.nextInt());
        }

        System.out.print("Cac phan tu cua danh sach la: ");
        Node currentNode = linkedList2.top;
        while (currentNode!= null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

        System.out.print("Nhap vao vi tri can tim ( nho hon n ) : ");
        int k = sc.nextInt();
        System.out.print("Gia tri o vi tri thu " + k + " la: " + linkedList2.get(k));

    }
}
