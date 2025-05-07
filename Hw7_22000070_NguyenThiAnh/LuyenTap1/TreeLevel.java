package Hw7_22000070_NguyenThiAnh.LuyenTap1;

public class TreeLevel {
    class Node{
        int data;
        Node left;
        Node right;
    }
    private Node root;
    private int n;

    public TreeLevel() {
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
    public static boolean isLeaf(Node node) {
        if(node.left== null && node.right == null) {
            return true;
        }
        return false;
    }

    public int treeLevel(Node node) {
        if (node == null) {
            return -1;
        }
        if (isLeaf(node)) {
            return 0;
        }
        return 1 + Math.max(treeLevel(node.left), treeLevel(node.right));
    }

    public static void main(String[] args) {
        int a[] = {4, 7, 2, 1, 3, 2, 5};
        TreeLevel tree = new TreeLevel();
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        System.out.println("So bac cua cay la : " + tree.treeLevel(tree.root));
    }
}
