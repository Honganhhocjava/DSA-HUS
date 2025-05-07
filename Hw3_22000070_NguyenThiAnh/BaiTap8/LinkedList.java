package Hw3_22000070_NguyenThiAnh.BaiTap8;


// De bai : Cho đầu của một danh sách liên kết và số k, nhiệm vụ của bạn là tìm nút k thứ từ cuối.
// Nếu k lớn hơn số lượng nút, thì đầu ra nên là -1.
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

    public int count() {
        int count = 0;
        Node currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
    public int getKthFromLast(int k) {
        if (head == null || k <= 0) {
            return -1;
        }

        if (k > count()) {
            return -1; // Nếu k lớn hơn số lượng phần tử
        }

        // Di chuyển đến nút k-th từ cuối
        Node current = head;
        for (int i = 0; i < count() - k ; i++) {
            current = current.next;
        }

        return current.data;
    }

    public static void main(String[] args) {
        LinkedList getIndex = new LinkedList();
        getIndex.addBot(1);
        getIndex.addBot(2);
        getIndex.addBot(3);
        getIndex.addBot(4);
        getIndex.addBot(5);
        getIndex.addBot(6);
        getIndex.addBot(7);
        getIndex.addBot(8);
        getIndex.addBot(9);

        System.out.print("cac phan tu trong danh sach: ");
        Node cuNode = getIndex.head;
        while (cuNode!= null) {
            System.out.print(cuNode.data + " ");
            cuNode = cuNode.next;
        }

        int k = 10;
        System.out.println("\nphan tu o vi tri thu " + k + " la: " + getIndex.getKthFromLast(k));

        int k1 = 2;
        System.out.println("phan tu o vi tri thu " + k1 + " la: " + getIndex.getKthFromLast(k1));
    }

}
