package Hw3_22000070_NguyenThiAnh.BaiTap10;

public class LinkedList {
    class Node{
        Node next;
        int data;
    }

    private Node head;
    private Node tail;
    private int n = 0;

    public void addHead(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(head == null) {
           head = newNode;
           tail = newNode;
           return;
        } else {
            newNode.next = head;
            head = newNode;
        }
        n++;
    }

    public void addBot(int data) {
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

    public LinkedList reverseList() {
        Node currentNode = head;
        LinkedList linkedList = new LinkedList();
        while (currentNode!= null){
            linkedList.addHead(currentNode.data);
            currentNode = currentNode.next;
        }
        return linkedList;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addBot(1);
        linkedList.addBot(2);
        linkedList.addBot(3);
        linkedList.addBot(4);
        linkedList.addBot(5);
        linkedList.addBot(6);
        linkedList.addBot(7);

        System.out.print("cac phan tu trong danh sach: ");
        Node current = linkedList.head;
        while (current!= null) {
            System.out.print(current.data +  " ");
            current=current.next;
        }

        System.out.println("\ncac phan tu danh sach sau khi dao nguoc la : ");
        LinkedList linkedList1 = linkedList.reverseList();
        Node current1 = linkedList1.head;
        while (current1!= null) {
            System.out.print(current1.data +  " ");
            current1=current1.next;
        }
    }

}
