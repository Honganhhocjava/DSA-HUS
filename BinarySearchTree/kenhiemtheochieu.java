package BST;

public class kenhiemtheochieu {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    // Phương thức chèn một nút mới vào cây
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Phương thức tìm nút có giá trị nhỏ nhất trong cây con
    private Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    // Phương thức tìm người kế vị theo thứ tự giữa
    public int inorderSuccessor(Node root, Node k) {
        if (k.right != null) {
            Node successor = minValueNode(k.right);
            return successor.data;
        }

        Node successor = null;
        while (root != null) {
            if (k.data < root.data) {
                successor = root;
                root = root.left;
            } else if (k.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }

        return (successor != null) ? successor.data : -1;
    }

    public static void main(String[] args) {
        kenhiemtheochieu tree = new kenhiemtheochieu();
        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
        tree.insert(12);
        tree.insert(10);
        tree.insert(14);

        Node k = tree.root.left; // Nút với giá trị 8
        int successor = tree.inorderSuccessor(tree.root, k);

        if (successor != -1) {
            System.out.println("Người kế vị theo thứ tự giữa của " + k.data + " là " + successor);
        } else {
            System.out.println("Không có người kế vị theo thứ tự giữa");
        }
    }
}
