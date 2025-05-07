package Tree;

public class Miror {
    class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node TreeMiror(Node node) {
        if(node == null) {
            return node;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        TreeMiror(node.left);
        TreeMiror(node.right);
        return node;
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Miror tree = new Miror();
        Node node1 = tree.new Node(1);
        node1.left = tree.new Node(3);
//          node1.left.left = tree.new Node(40);
//          node1.left.right = tree.new Node(60);
        node1.right = tree.new Node(2);
//        node1.right.left = tree.new Node(5);
//        node1.right.right = tree.new Node(4);

        System.out.println("Inorder traversal of original tree:");
        tree.inorder(node1);
        System.out.println();

        tree.TreeMiror(node1);
        System.out.println("Inorder traversal of mirror tree:");
        tree.inorder(node1);
        System.out.println();
    }
}
