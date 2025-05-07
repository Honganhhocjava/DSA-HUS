package BST;

public class Minimum {
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

    public int findMin(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public static void main(String[] args) {
        Minimum tree = new Minimum();
        int[] a = {10,10,11};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        System.out.println("Minimum value in the BST: " + tree.findMin(tree.root));
    }
}
