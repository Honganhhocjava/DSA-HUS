package BST;

import java.util.ArrayList;
import java.util.List;

public class Canbang {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }


    public static boolean IsCanBang(int[] num) {
        int mid = num.length/2;
        int m = (mid) - (num.length - 1- mid);
       // System.out.println(m);
        if(Math.abs(m) <=1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        System.out.println(IsCanBang(a));
    }
}
