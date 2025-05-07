package Hw3_22000070_NguyenThiAnh.BaiTap6;

import java.util.Scanner;

public class MyLinkedList {
    class MyLinkedNode {
        MyLinkedNode next;
        int val;
    }

    private MyLinkedNode head;
    private MyLinkedNode tail;
    private int n = 0;

    public int get(int index) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        MyLinkedNode newNode = new MyLinkedNode();
        newNode.val = val;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
        n++;
    }

    public void addAtTail(int val) {
        MyLinkedNode newNode = new MyLinkedNode();
        newNode.val = val;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    public void addAtIndex(int index, int val) {
        MyLinkedNode newNode = new MyLinkedNode();
        newNode.val = val;
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addAtHead(val);
        } else if (index == (n - 1)) {
            addAtTail(val);
        } else {
            MyLinkedNode currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        n++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            head = head.next;
            n--;
        } else {
            MyLinkedNode cuNode = head;
            for (int i = 0; i < index - 1; i++) {
                cuNode = cuNode.next;
            }
            cuNode.next = cuNode.next.next;
            if (index == (n - 1)) {
                tail = cuNode;
            }
            n--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(10);
        myLinkedList.addAtIndex(0,11);
        myLinkedList.addAtIndex(1, 8);
        System.out.print("cac phan tu trong danh sach: ");
        MyLinkedNode currentNode = myLinkedList.head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }

        System.out.println("\nlay ra phan tu tai vi tri so 1 la: " + myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.print("cac phan tu trong danh sach sau khi xoa o vi tri 1 la: ");
        MyLinkedNode currentNode1 = myLinkedList.head;
        while (currentNode1 != null) {
            System.out.print(currentNode1.val + " ");
            currentNode1 = currentNode1.next;
        }
        System.out.println("\nlay ra phan tu tai vi tri so 1 la: " + myLinkedList.get(1));

    }


}



