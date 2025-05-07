    package BST;

    public class DeleteNode {
        class Node{
            int data;
            Node left,right;

            public Node(int data) {
                this.data = data;
                this.left = this.right = null;
            }
        }
        private Node root;


        public void insert(int data) {
            root = insert(root,data);
        }

        public Node insert (Node node, int data) {
            Node newNode= new Node(data);
            if(node==null) {
                return newNode;
            }

            if(node.data > data) {
                node.left = insert(node.left,data);
            }
            if(node.data < data) {
                node.right = insert(node.right,data);
            }
            return node;
        }

        public void delete(int data) {
            root = delete(root,data);
        }

        public Node delete(Node node , int data) {
            if(node == null) {
                return null;
            }
            if (data < node.data) {
                node.left = delete(node.left, data);
            } else if (data > node.data) {
                node.right = delete(node.right, data);
            } else {
                if (node.left == null) {
                    return node.right;
                }

                if (node.right == null) {
                    return node.left;
                }
                Node cuNode = findNode(node.left);
                System.out.println(cuNode.data);
                node.data = cuNode.data;
                node.left = delete(node.left,cuNode.data);
            }
            return node;
        }

        public Node findNode(Node node) {
            Node currentNode = node;
            while (currentNode.right!= null) {
                currentNode = currentNode.right;
            }
            return currentNode;
        }

        public void print(Node node) {
            if(node==null) {
                return;
            }

            System.out.print(node.data + " ");
            print(node.left);
            print(node.right);
        }

        public static void main(String[] args) {
            DeleteNode tree = new DeleteNode();
            int []a ={5,3,6,2,4,7};
            for (int i = 0; i < a.length; i++) {
                tree.insert(a[i]);
            }
            tree.print(tree.root);
            tree.delete(3);
            System.out.println();
            tree.print(tree.root);

        }
    }
