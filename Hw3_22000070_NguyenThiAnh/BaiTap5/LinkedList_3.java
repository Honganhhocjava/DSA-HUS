package Hw3_22000070_NguyenThiAnh.BaiTap5;


import java.util.Scanner;

// De bai : Nhập vào một số nguyên dương n, tiếp theo là n số nguyên của một dãy số,
// hãy cài đặt nó vào một danh sách liên kết đơn. Tiếp theo nhập hai số nguyên a và b.
//Hãy thay đổi giá trị của những phần tử có giá trị a thành giá trị b.
// In ra màn hình danh sách đó, sau một phần tử có đúng một khoảng trắng.
public class LinkedList_3 {
    public class Node{
        Node next;
        int data;
    }

    private Node top;
    private Node bot;
    private int n = 0;

    public void addBot(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(top == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public boolean isContains(int data) {
        Node cuNode = top;
        for (int i = 0; i < n; i++) {
            if (cuNode.data == data) {
                return true;
            }
            cuNode = cuNode.next;
        }
        return false;
    }


    public void convert(int a , int b) {
        Node cuNode = top;
        if (isContains(a)) {
            for (int i = 0; i < n; i++) {
                if(cuNode.data == a) {
                    cuNode.data = b;
                }
                cuNode = cuNode.next;
            }
        } else {
            System.out.print("gia tri " + a + " khong ton tai trong danh sach ");
        }
    }


    public static void main(String[] args) {
        LinkedList_3 linkedList3 = new LinkedList_3();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        System.out.print("Nhap vap cac phan tu cua danh sach: ");
        for (int i = 0; i < n; i++) {
            linkedList3.addBot(sc.nextInt());
        }
        System.out.print("Nhap vao gia tri can than thay the: ");
        int a = sc.nextInt();
        System.out.print("Nhap vao gia tri thay the: ");
        int b = sc.nextInt();

        linkedList3.convert(a,b);

        Node cuNode = linkedList3.top;
        while (cuNode!= null) {
            System.out.print(cuNode.data + " ");
            cuNode = cuNode.next;
        }
    }
}
