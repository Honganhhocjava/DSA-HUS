package BST;

import java.util.*;

public class lardge {
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

    public int findK(Node node , int k) {
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
        Collections.reverse(list);
        System.out.println(list);
        return list.get(k-1);
    }

    public static void main(String[] args) {
        lardge lardge = new lardge();
        int a[] = {4,2,9};
        for (int i = 0; i < a.length; i++) {
            lardge.insert(a[i]);
        }
        System.out.println(lardge.findK(lardge.root, 3));
    }
}
