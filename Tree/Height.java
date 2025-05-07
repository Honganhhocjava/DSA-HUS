package Tree;

public class Height {
    class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data= data;
            this.left = this.right = null;
        }
    }
    private Node root;
    public int hight(Node node) {
        if(node == null) {
            return -1;
        }
        if(isLeaf(node)) {
            return 0;
        }
        return 1+ Math.max(hight(node.left),hight(node.right));
    }
    public boolean isLeaf(Node node) {
       return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Height tree = new Height();
        tree.root = tree.new Node(1);
//        tree.root.left = tree.new Node(2);
//        tree.root.right = tree.new Node(3);
//        tree.root.left.left = tree.new Node(4);
//        tree.root.right.right = tree.new Node(5);
//        tree.root.right.right.right = tree.new Node(7);
        System.out.println( tree.hight(tree.root));
    }

}
