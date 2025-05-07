package BST;
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}


public class TrimTree {

        public Node trimBST(Node root, int low, int high) {
            if (root == null) {
                return null;
            }

            if (root.data < low) {
                return trimBST(root.right, low, high);
            }

            if (root.data > high) {
                return trimBST(root.left, low, high);
            }

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }

        public void printTree(Node node) {
            if (node == null) {
                return;
            }
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }

        public static void main(String[] args) {
           TrimTree tree = new TrimTree();
            Node root = new Node(3);
            root.left = new Node(0);
            root.right = new Node(4);
            root.left.right = new Node(2);
            root.left.right.left = new Node(1);

            System.out.println("Cây trước khi cắt tỉa:");
            tree.printTree(root);
            System.out.println();

            int low = 1, high = 3;
            root = tree.trimBST(root, low, high);

            System.out.println("Cây sau khi cắt tỉa:");
            tree.printTree(root);
            System.out.println();
        }


}
