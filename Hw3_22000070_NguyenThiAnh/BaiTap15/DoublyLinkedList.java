package Hw3_22000070_NguyenThiAnh.BaiTap15;

public class DoublyLinkedList {
    class Node {
        Node next;
        Node prev;
        int data;
    }

    private Node head;
    private Node tail;
    private int n = 0;


    private void addBot(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = tail = newNode;
            return;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        n++;

    }


    public void rotateByN(int p) {
        if (p < 0 || p > n) {
            throw new IndexOutOfBoundsException();
        } else if (p == 0) {
            return;
        }
        Node currentNode = head;
        while (p > 0) {
            currentNode = currentNode.next;
            p--;
        }
        tail = currentNode.prev;
        Node newHead = currentNode;
        currentNode.prev = null;
        tail.next = null;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = head;
        head.prev = currentNode;
        head = newHead;
    }

    public void printList() {
        Node cuNode = head;
        while (cuNode != null) {
            System.out.print(cuNode.data + " ");
            cuNode = cuNode.next;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addBot(1);
        doublyLinkedList.addBot(2);
        doublyLinkedList.addBot(3);
        doublyLinkedList.addBot(4);
        doublyLinkedList.addBot(9);
        System.out.print("Truoc khi xoay: ");
        doublyLinkedList.printList();

        doublyLinkedList.rotateByN(2);

        System.out.print("\nSau khi xoay 2 lan : ");
        doublyLinkedList.printList();
    }
}





