package Hw3_22000070_NguyenThiAnh.Baitap12;

// De bai: Cho đầu của một danh sách liên kết đã được sắp xếp,
// hãy xóa tất cả các phần tử trùng lặp sao cho mỗi phần tử chỉ xuất hiện một lần.
// Trả về danh sách liên kết đã được sắp xếp.
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
    }

    public LinkedList deleteDuplicates() {
        if (head == null) return this;
        Node currentNode1 = head;
        Node currentNode2 = head.next;
        while (currentNode1!=null && currentNode2!=null) {
            if(currentNode1.data == currentNode2.data) {
                currentNode1.next = currentNode2.next;
                currentNode2= currentNode2.next;
            } else {
                currentNode1 = currentNode1.next;
            }
        }
        return this;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Thêm các phần tử vào danh sách (có chứa phần tử trùng lặp)
        list.addBot(1);
        list.addBot(1);
        list.addBot(2);
        list.addBot(3);
        list.addBot(3);
        list.addBot(4);
        list.addBot(4);
        list.addBot(4);
        list.addBot(5);

        System.out.println("Danh sách ban đầu:");
        list.printList();

        list.deleteDuplicates();
        System.out.println("Danh sách sau khi xóa trùng lặp:");
        list.printList();
    }
}
