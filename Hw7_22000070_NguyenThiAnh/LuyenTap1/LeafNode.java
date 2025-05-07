package Hw7_22000070_NguyenThiAnh.LuyenTap1;

public class LeafNode {
    private Node root;
    private int n;
    class Node{
        int data;
        Node left;
        Node right;
    }

    public LeafNode() {
        this.root = null;
        this.n = 0;
    }

    public void insert(int data) {
        root = insert(root,data);

    }

    private Node insert(Node node, int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(node == null) {
            n++;
            return newNode;
        }
        if(node.data >= data) {
            node.left = insert(node.left,data);
        }
        if(node.data < data) {
            node.right = insert(node.right,data);
        }
        return node;
    }

    public static boolean isLeafNode(Node node) {
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    public static int countLeaf(Node node) {
        if(node == null) {
            return 0;
        }
        if(isLeafNode(node)) {
            return 1;
        }

        return countLeaf(node.left) + countLeaf(node.right);
    }


    public static void main(String[] args) {
        LeafNode tree = new LeafNode();
        int[] a = {10,5,15,3,7};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

        System.out.println("So la trong cay la : " + countLeaf(tree.root));

    }
}
