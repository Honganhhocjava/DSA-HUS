    package Tree;

    public class NonLeaf {
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

        private Node insert(Node node , int data) {
            Node newNode = new Node(data);
            if(node == null) {
                n++;
              return newNode;
            }
            if(node.data > data) {
                node.left = insert(node.left, data);
            }
            if(node.data < data) {
                node.right = insert(node.right,data);
            }
            return node;
        }

        public boolean isLeaf(Node node) {
            return node.left == null && node.right == null;
        }

        public int countNonLeaf(Node node) {
            if(node == null || isLeaf(node)) {
                return 0;
            }
            return 1+ (countNonLeaf(node.left) + countNonLeaf(node.right));
        }

        public static void main(String[] args) {
            NonLeaf tree = new NonLeaf();
            NonLeaf tree1 = new NonLeaf();
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
