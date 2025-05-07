package Hw3_22000070_NguyenThiAnh.BaiTap16;

// De bai : Cho một danh sách liên kết vòng, nhiệm vụ của bạn là hoàn thành
// phương thức printList() để in danh sách liên kết.
//Phuong thuc deleteNode() Nhiệm vụ là xóa nút đã cho,khóa trong danh sách liên kết vòng, và đảo ngược danh sách liên kết vòng.
// phuong thuc  isCircular() kiem tra danh sach phai lien ket vong khong
//Phuong thuc sortedInsert(int data) thêm phần tử vào danh sách liên kết vòng tăng dần

public class CircularLinkedList {
    class Node {
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
            head = tail = newNode;
            tail.next = head;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        n++;
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


    public boolean isCircular() {
        if (head == null) {
            return false;
        }
        Node currentNode = head;
        do {
            currentNode = currentNode.next;
            if (currentNode == head) {
                return true;
            }
        } while (currentNode != null && currentNode != head);
        return false;
    }

    public void sortedInsert(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(head== null) {
            newNode.next = newNode;
            head = newNode;
            tail = newNode;
        } else if(data < head.data) {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        Node currentNode = head;
        do{
            if (currentNode.next == head || currentNode.next.data > newNode.data) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                return;
            }
            currentNode = currentNode.next;
        } while (currentNode != head);

        tail = newNode;
        tail.next = head;
    }

    public void deleteNode(int data) {
        if (head == null) return;
        Node currentNode = head;
        Node previousNode = null;
        if (head.data == data) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            n--;
            reverseList();
            return;
        }

        do {
            previousNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != head && currentNode.data != data);
        if (currentNode.data == data) {
            previousNode.next = currentNode.next;

            if (currentNode == tail) {
                tail = previousNode;
                tail.next = head;
            }
            n--;
        }
        reverseList();
    }

    public void reverseList() {
        if (head == null || head.next == head) return; // Nếu danh sách rỗng hoặc chỉ có 1 phần tử

        Node previous = tail; // tail sẽ trở thành nút đầu tiên sau khi đảo ngược
        Node current = head;
        Node next;

        do {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        } while (current != head);
        tail = head;
        head = previous;
        tail.next = head;
    }


    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addBot(3);
        circularLinkedList.addBot(5);
        circularLinkedList.addBot(7);
        circularLinkedList.addBot(9);
        circularLinkedList.printList();
        System.out.println(circularLinkedList.isCircular());
        circularLinkedList.sortedInsert(8);
        System.out.println("Sau khi them"); circularLinkedList.printList();
        circularLinkedList.deleteNode(8);
        System.out.println("Sau khi xoa phan tu 8 : ");circularLinkedList.printList();

    }
}
