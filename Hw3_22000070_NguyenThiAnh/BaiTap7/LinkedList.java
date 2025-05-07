package Hw3_22000070_NguyenThiAnh.BaiTap7;

//De bai : Dem so phan tu cua danh sach lien ket
public class LinkedList {
    class Node{
        Node next;
        int data;
    }

    private Node head;
    private Node tail;
    private int n = 0;

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

    public int countNode() {
        int count = 0;
        Node currentNode = head;
        while (currentNode!= null) {
            count++;
            currentNode = currentNode.next;

        }
        return count;
    }

    public static void main(String[] args) {
        LinkedList countNode = new LinkedList();
        countNode.addBot(3);
        countNode.addBot(2);
        countNode.addBot(6);
        countNode.addBot(8);
        countNode.addBot(1);
        countNode.addBot(4);
        System.out.print("Cac phan tu trong danh sach la: ");
        Node cuNode = countNode.head;
        while (cuNode!= null) {
            System.out.print(cuNode.data + " ") ;
            cuNode = cuNode.next;
        }

       System.out.println("\nSo phan tu trong danh sach la :" + countNode.countNode());
    }

}
