package BST;
import java.util.*;
public class Floor {
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

    public int floor(Node node , int x){
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
        Collections.sort(list);
        int min = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(0) > x) {
                return -1;
            }
            if(list.get(i) ==x){
                return x;
            }
            if(list.get(i) < x) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Floor tree = new Floor();
        int a[] = {2,81,42,87,66,90,45};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

        System.out.println(tree.floor(tree.root, 87));
    }

}
