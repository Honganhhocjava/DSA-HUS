package Hw3_22000070_NguyenThiAnh.BaiTap17;

// Debai: chia danh sach lien ket vong thanh 2 danh sach lien ket vong,
// neu danh sach ban dau le thi danh sach dau tien yeu tien nhieu phan tu hon danh sach thu 2
public class CircularLinkedList {
    class Node{
        Node next;
        int data;

    }

    private Node head;
    private Node tail;
    private int n  = 0;


    public void addBot(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(head == null) {
            head = tail = newNode;
            tail.next = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        n++;
    }

    public int size() {
         return n ;
    }


    public CircularLinkedList[] splitList() {
        CircularLinkedList circularLinkedList1 = new CircularLinkedList();
        CircularLinkedList circularLinkedList2 = new CircularLinkedList();

        int splitPoint;
        if (n % 2 == 0) {
            splitPoint = n / 2;
        } else {
            splitPoint = n / 2 + 1;
        }

        Node currentNode = head;
        for (int i = 0; i < splitPoint; i++) {
            circularLinkedList1.addBot(currentNode.data);
            currentNode = currentNode.next;
        }

        for (int i = splitPoint; i < n; i++) {
            circularLinkedList2.addBot(currentNode.data);
            currentNode = currentNode.next;
        }

        return new CircularLinkedList[]{circularLinkedList1, circularLinkedList2};
    }

    public void printList() {
        if (head == null) return;
        Node currentNode = head;
        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != head);
        System.out.println();
    }


    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.addBot(1);
        list.addBot(2);
        list.addBot(3);
        list.addBot(4);
        list.addBot(5);
        list.addBot(9);

        System.out.println("Danh sach vong ban dau :");
        list.printList();

        CircularLinkedList[] splitLists = list.splitList();

        System.out.println("Danh sách 1:");
        splitLists[0].printList();


        System.out.println("Danh sách 2:");
        splitLists[1].printList();
    }

}

