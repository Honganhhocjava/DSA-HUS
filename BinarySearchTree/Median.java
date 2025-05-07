package BST;

import java.util.*;

public class Median {
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

    public double Med(Node node) {
        double result=0;
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
        System.out.println(list);

        if(list.size() %2 != 0 ) {
            result = list.get(list.size() /2);

        }else {
          int mid = list.size() /2;
          int mid2 = mid -1;
          System.out.println(list.get(mid2));
          result = (double) (list.get(mid) + list.get(mid2))/2;
          //System.out.println(result);

        }
        return result;

    }

    public static void main(String[] args) {
        Median tree = new Median();
        int a[] ={18,16,20,7};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        System.out.println(  tree.Med(tree.root));
    }
}
