package BST;
import  java.util.*;
public class Search {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }
    public boolean search(Node node , int x) {
        List<Integer> list = new ArrayList<>();
        if(node == null) {
            return false;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node e = q.poll();
            list.add(e.data);
            if(e.left !=null) {
                q.add(e.left);
            }
            if(e.right!=null) {
                q.add(e.right);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search tree = new Search();
        int a[] = {2,81,42,87,66,90,45};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

        System.out.println(tree.search(tree.root, 89));
    }

}
