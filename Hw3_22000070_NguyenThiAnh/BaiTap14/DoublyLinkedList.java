package Hw3_22000070_NguyenThiAnh.BaiTap14;

// De bai : Cho một danh sách liên kết đôi, một vị trí p, và một số nguyên x.
// 1.Nhiệm vụ là thêm một nút mới với giá trị x vào vị trí ngay sau nút thứ p trong danh sách liên kết đôi
// và trả về đầu của danh sách đã được cập nhật.
// 2. Nhiệm vụ là xóa một nút từ vị trí đã cho (vị trí bắt đầu từ 1) trong danh sách liên kết đôi
// và trả về đầu của danh sách liên kết đôi.
// 3. Nhiem vu la chen data vao danh sach lien ket
public class DoublyLinkedList {
    class Node {
        Node next;
        Node prev;
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
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }
        n++;
    }


    public void addAt(int p, int data) {
        if (p < 0 || p > n) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node();
        newNode.data = data;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (p == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node currentNode = head;
            for (int i = 0; i < p - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            if (currentNode.next != null) {
                currentNode.next.prev = newNode;
            }
            currentNode.next = newNode;
            newNode.prev = currentNode;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
        n++;
    }

    public void deleteNode(int x) {
        if(x < 0 || x > n) {
            throw new IndexOutOfBoundsException();
        } else if (x == 0) {
            head = head.next;
        } else if( x == (n -1)){
            tail = tail.prev;
        } else {
            Node currentNode = head;
            for (int i = 0; i < x; i++) {
               currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        n--;

    }

    public void sortedInsert(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = tail = newNode;
        }
        else if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if (data >= tail.data) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        Node currentNode = head;
        while (currentNode != null && currentNode.data < data) {
            currentNode = currentNode.next;
        }
        newNode.prev = currentNode.prev;
        newNode.next = currentNode;
        currentNode.prev.next = newNode;
        currentNode.prev = newNode;
        n++;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode!= null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addBot(1);
        doublyLinkedList.addBot(2);
        doublyLinkedList.addBot(3);
        doublyLinkedList.addBot(4);
        doublyLinkedList.addBot(9);
        System.out.print("Truoc khi them: ") ; doublyLinkedList.printList();

        doublyLinkedList.addAt(4,8);
        doublyLinkedList.addAt(4,6);

        System.out.print("\nSau khi them: ") ; doublyLinkedList.printList();

        doublyLinkedList.deleteNode(0);


        System.out.print("\nSau khi xoa tai vi tri 0 la : ") ; doublyLinkedList.printList();

        doublyLinkedList.deleteNode(0);
        System.out.print("\nSau khi xoa tai vi tri 0 la : ") ; doublyLinkedList.printList();

        doublyLinkedList.sortedInsert(7);
        System.out.print("\nSau khi them data = 7 la : ") ; doublyLinkedList.printList();


    }

}
