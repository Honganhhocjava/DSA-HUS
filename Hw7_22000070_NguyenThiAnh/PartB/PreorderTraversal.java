package Hw7_22000070_NguyenThiAnh.PartB;

public class PreorderTraversal {
    static  class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right=null;
        }
    }

    private Node root;

    public static void printPre(Node node) {
        if(node!=null) {
            System.out.print(node.data + " ");
            printPre(node.left);
            printPre(node.right);
        }
    }

    public static void main(String[] args) {
        PreorderTraversal tree = new PreorderTraversal();
        tree.root = new Node(8);
        tree.root.left =new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);
        printPre(tree.root);

    }

}
