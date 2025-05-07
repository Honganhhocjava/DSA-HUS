package Tree;

public class LeafNode {
    class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    private Node root;
    private int n;

    public void insert(int data) {
        root = insert(root,data);

    }

    private Node insert(Node node, int data) {
        Node newNode = new Node(data);

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

    public boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public int countLeaf(Node node) {
        int count=0;
        if(node == null) {
            return 0;
        }
        if(isLeaf(node)) {
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

        System.out.println("So la trong cay la : " + tree.countLeaf(tree.root));
    }
}
