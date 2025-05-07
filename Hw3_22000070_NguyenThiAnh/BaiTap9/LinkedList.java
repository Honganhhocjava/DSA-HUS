package Hw3_22000070_NguyenThiAnh.BaiTap9;

public class LinkedList {
    class Node{
        Node next;
        int data;
    }
    private Node head;
    private Node tail;
    private int n = 0;

    public void addBot(int data){
        Node newNode = new Node();
        newNode.data = data;
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    public int count(int key) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addBot(1);
        linkedList.addBot(2);
        linkedList.addBot(1);
        linkedList.addBot(2);
        linkedList.addBot(1);
        linkedList.addBot(3);
        linkedList.addBot(1);

        System.out.print("cac phan tu trong danh sach: ");
        Node current = linkedList.head;
        while (current!= null) {
            System.out.print(current.data +  " ");
            current=current.next;
        }

        System.out.println("\nSo lan xuat hien cua 1 la: " + linkedList.count(1) ) ;

    }


}
