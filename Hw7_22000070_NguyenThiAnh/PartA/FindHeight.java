package Hw7_22000070_NguyenThiAnh.PartA;

public class FindHeight {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public FindHeight() {
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

    public boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public int findHeight(Node node) {
        if (node == null) {
            return -1;
        }
        if (isLeaf(node)) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }

    public static void main(String[] args) {
        FindHeight tree = new FindHeight();
        int[] a = {1, 2, 3};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        System.out.println("Height of the tree: " + tree.findHeight(tree.root));
    }
}
