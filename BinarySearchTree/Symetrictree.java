package BST;

public class Symetrictree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;


    public boolean isSymmetric(Node root) {
        if(root== null) {
            return true;
        }
        return check(root.left,root.right);
    }

    public boolean check(Node node1,Node node2) {
        if(node1 == null && node2 == null) {
            return true;
        }

        if(node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node2.data && check(node1.left,node2.right) && check(node1.right , node2.left);
    }

    public static void main(String[] args) {
        Symetrictree tree = new Symetrictree();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(2);
        tree.root.left.left = tree.new Node(3);
        tree.root.left.right = tree.new Node(4);
        tree.root.right.right = tree.new Node(3);
        tree.root.right.left = tree.new Node(4);
//        tree.root.right.left = tree.new Node(0);
//        tree.root.right.right = tree.new Node(8);
        System.out.println(tree.isSymmetric(tree.root));
    }

}
