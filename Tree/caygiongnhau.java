package Tree;

public class caygiongnhau {
    class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    private Node root;

    public boolean isIdentical(Node node1 , Node node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 !=null && node2 != null) {
           return node1.data == node2.data &&( isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right));
        }
        return false;
    }


    public static void main(String[] args) {
        caygiongnhau tree = new caygiongnhau();
        caygiongnhau tree1 = new caygiongnhau();
        Node node1 = tree.new Node(1);
        node1.left = tree.new Node(2);
        node1.right = tree.new Node(3);

        Node node2 = tree.new Node(1);
        node2.left = tree.new Node(2);
        node2.left = tree.new Node(3);
       if( tree.isIdentical(node1,node2)) {
           System.out.println("Cay giong nhau");
       } else {
           System.out.println("Khong giong nhau");
       }


    }
}
