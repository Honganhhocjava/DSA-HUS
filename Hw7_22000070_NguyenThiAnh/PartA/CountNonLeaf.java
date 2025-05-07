package Hw7_22000070_NguyenThiAnh.PartA;

public class CountNonLeaf {
    class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public CountNonLeaf() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root,data);
    }

    private Node insert(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }

        if(data < node.data) {
            node.left = insert(node.left,data);
        }else {
            node.right = insert(node.right,data);
        }
        return node;
    }

    public boolean isLeaf(Node node) {
        if(node.right == null && node.left == null) {
            return true;
        }
        return false;
    }


    public int countNonLeaf(Node node) {
        int count = 0;
        if(node == null) {
            return 0;
        }
        if(!isLeaf(node)) {
           count=1;
        }

        count+=countNonLeaf(node.left);
        count+=countNonLeaf(node.right);
        return count;
    }

    public static void main(String[] args) {
        CountNonLeaf tree = new CountNonLeaf();
        CountNonLeaf tree1 = new CountNonLeaf();
        int []a = {10,5,20,3,7,15,25};
        int[]b ={8,3,9,1,6};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        for (int i = 0; i <b.length ; i++) {
            tree1.insert(b[i]);
        }
        System.out.println("tổng số nút không phải là lá : " + tree.countNonLeaf(tree.root));
        System.out.println("tổng số nút không phải là lá : " + tree1.countNonLeaf(tree1.root));

    }
}
