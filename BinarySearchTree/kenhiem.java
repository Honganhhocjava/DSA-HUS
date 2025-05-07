package BST;

public class kenhiem {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        if (root == null) return;

        // Nếu tìm thấy nút có giá trị key
        if (root.data == key) {
            // Tìm phần tử trước (predecessor)
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                pre[0] = tmp;
            } else {
                pre[0] = new Node(-1); // Trả về -1 nếu không có phần tử trước
            }

            // Tìm phần tử sau (successor)
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                suc[0] = tmp;
            } else {
                suc[0] = new Node(-1); // Trả về -1 nếu không có phần tử sau
            }
            return;
        }

        // Nếu key nhỏ hơn giá trị của nút hiện tại
        if (key < root.data) {
            suc[0] = root;
            findPreSuc(root.left, pre, suc, key);
        } else { // Nếu key lớn hơn giá trị của nút hiện tại
            pre[0] = root;
            findPreSuc(root.right, pre, suc, key);
        }
    }

    public static void main(String[] args) {
        kenhiem tree = new kenhiem();
        tree.root = tree.new Node(50);
        tree.root.left = tree.new Node(30);
        tree.root.right = tree.new Node(70);
        tree.root.left.left = tree.new Node(20);
        tree.root.left.right = tree.new Node(40);
        tree.root.right.left = tree.new Node(60);
        tree.root.right.right = tree.new Node(80);

        int key = 65;
        Node[] pre = new Node[1];
        Node[] suc = new Node[1];

        tree.findPreSuc(tree.root, pre, suc, key);
        if (pre[0] != null && pre[0].data != -1) {
            System.out.println("Phần tử trước (Predecessor) là: " + pre[0].data);
        } else {
            System.out.println("Không có phần tử trước (Predecessor)");
        }

        if (suc[0] != null && suc[0].data != -1) {
            System.out.println("Phần tử sau (Successor) là: " + suc[0].data);
        } else {
            System.out.println("Không có phần tử sau (Successor)");
        }
    }
}
