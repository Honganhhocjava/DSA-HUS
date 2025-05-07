

package BST;

public class LowestCommonAncestor {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        // Nếu giá trị của nút hiện tại lớn hơn cả n1 và n2, chuyển sang cây con bên trái
        if (root.data > n1 && root.data > n2) {
            return findLCA(root.left, n1, n2);
        }

        // Nếu giá trị của nút hiện tại nhỏ hơn cả n1 và n2, chuyển sang cây con bên phải
        if (root.data < n1 && root.data < n2) {
            return findLCA(root.right, n1, n2);
        }

        // Nếu giá trị của nút hiện tại nằm giữa n1 và n2, nút hiện tại là LCA
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        Node root = tree.new Node(5);
        root.left = tree.new Node(4);
        root.right = tree.new Node(6);
       root.left.left = tree.new Node(3);
//        //root.left.right = tree.new Node(12);
//        //root.left.right.left = tree.new Node(10);
      root.right.right = tree.new Node(7);
      root.right.right.right = tree.new Node(8);

        int n1 = 4, n2 = 3;
        Node lca = tree.findLCA(root, n1, n2);
        System.out.println("Tổ tiên Chung Thấp Nhất của " + n1 + " và " + n2 + " là: " + lca.data);
    }
}
