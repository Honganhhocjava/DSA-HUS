package Hw7_22000070_NguyenThiAnh.LuyenTap1;
import java.util.Scanner;

public class BinarySearchTree {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left != null) {
                node.left = null;
            }
            if (node.right != null) {
                node.right = null;
            }
            return null;
        }
        return node;
    }

    public void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int a[] = {5, 2, 7, 1, 3, 2, 4};
        int x = 3;
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        tree.delete(x);
        if (tree.root == null) {
            System.out.println("NULL");
        } else {
            tree.printTree(tree.root);
        }
    }
}
