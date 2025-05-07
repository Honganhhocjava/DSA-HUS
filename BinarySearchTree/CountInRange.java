package BST;
import java.util.*;
public class CountInRange {
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

    public int CountInRange(Node node, int l ,int r) {
        List<Integer> list = new ArrayList<>();
        if(node == null) {
            return -1;
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
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(l <= list.get(i) && list.get(i)<= r) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountInRange tree = new CountInRange();
        int a[] = {5, 4, 6, 3, 7};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

        System.out.println(tree.CountInRange(tree.root, 10 ,11));
    }

}
