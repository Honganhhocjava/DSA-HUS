package Hw3_22000070_NguyenThiAnh.Baitap13;

//De bai:Cho hai số đa thức được biểu diễn bằng danh sách liên kết. Nhiệm vụ là cộng các danh sách này lại,
// có nghĩa là cộng các hệ số với cùng một bậc biến. Lưu ý: Các đa thức đã cho được sắp xếp theo thứ tự giảm dần của bậc.
public class LinkedList {
    class Node{
        Node next;
        int data;
        int pow;
    }
    private Node head;
    private Node tail;
    private int n = 0 ;

    public void addBot(int data , int pow) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.pow = pow;
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public LinkedList addPolynomial(LinkedList linkedList1,LinkedList linkedList2){
        LinkedList result = new LinkedList();
        Node currentNode1 = linkedList1.head;
        Node currentNode2 = linkedList2.head;
        while (currentNode1 != null && currentNode2!= null){
            if(currentNode1.pow > currentNode2.pow) {
                result.addBot(currentNode1.data, currentNode1.pow);
                currentNode1 = currentNode1.next;
            } else if (currentNode1.pow < currentNode2.pow) {
                result.addBot(currentNode2.data, currentNode2.pow);
                currentNode2 = currentNode2.next;
            } else {
                int sumCoeff = currentNode1.data + currentNode2.data;
                result.addBot(sumCoeff, currentNode1.pow);
                currentNode1 = currentNode1.next;
                currentNode2 = currentNode2.next;
            }
        }
        while (currentNode1 != null) {
            result.addBot(currentNode1.data, currentNode1.pow);
            currentNode1 = currentNode1.next;
        }
        while (currentNode2 != null) {
            result.addBot(currentNode2.data, currentNode2.pow);
            currentNode2 = currentNode2.next;
        }

        return result;
    }

    public void printList() {
        Node currentNode = head;
        boolean firstTerm = true;
        while (currentNode != null) {
            if (currentNode.data != 0) {
                if (firstTerm) {
                    if (currentNode.data < 0) {
                        System.out.print("-");
                    }
                    System.out.print(Math.abs(currentNode.data));
                } else {
                    if (currentNode.data > 0) {
                        System.out.print(" + " + currentNode.data);
                    } else {
                        System.out.print(" - " + Math.abs(currentNode.data));
                    }
                }

                if (currentNode.pow > 1) {
                    System.out.print("x^" + currentNode.pow);
                } else if (currentNode.pow == 1) {
                    System.out.print("x");
                }

                firstTerm = false;
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedList poly1 = new LinkedList();
        LinkedList poly2 = new LinkedList();

        poly1.addBot(-5, 4);
        poly1.addBot(5, 2);
        poly1.addBot(4, 1);
        poly1.addBot(2, 0);

        poly2.addBot(-3, 3);
        poly2.addBot(2, 1);
        poly2.addBot(1, 0);

        System.out.println("Đa thức 1:");
        poly1.printList();

        System.out.println("Đa thức 2:");
        poly2.printList();

        LinkedList result = poly1.addPolynomial(poly1, poly2);

        System.out.println("Kết quả sau khi cộng hai đa thức:");
        result.printList();
    }
}
