package Hw3_22000070_NguyenThiAnh.BaiTap11;

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

    public boolean isPalindrome() {
        LinkedList reversedList = this.reverseList();
        Node currentOriginal = this.head;
        Node currentReversed = reversedList.head;
        while (currentOriginal != null && currentReversed != null) {
            if (currentOriginal.data != currentReversed.data) {
                return false;
            }
            currentOriginal = currentOriginal.next;
            currentReversed = currentReversed.next;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addBot(1);
        linkedList.addBot(2);
        linkedList.addBot(3);
        linkedList.addBot(3);
        linkedList.addBot(2);
        linkedList.addBot(1);

        System.out.print("cac phan tu trong danh sach: ");
        Node current = linkedList.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        if (linkedList.isPalindrome()) {
            System.out.println("\nDanh sách là palindrome.");
        } else {
            System.out.println("\nDanh sách không phải là palindrome.");
        }
    }
}
