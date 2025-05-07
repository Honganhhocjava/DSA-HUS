package BST;

import java.util.*;

public class timcayBSTcon {
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

    public int BstCon(Node node) {
        int max = -1;
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node e = queue.poll();
            int size = size(e);
            hashMap.put(e.data,size);
            if(e.left!=null) {
                queue.add(e.left);
            }
            if(e.right!=null) {
                queue.add(e.right);
            }
        }
        Set<Integer> set = hashMap.keySet();
        List<Integer> list = new ArrayList<>();
        for(int e :set) {
            list.add(e);
        }
        for (int i = 0; i < hashMap.size(); i++) {
            if(hashMap.get(list.get(i)) > max) {
                max = hashMap.get(list.get(i));
            }
        }
        return max;
    }


    public int size(Node node) {
        int count = 0;
        if(node == null) {
            return count;
        }
        if(node != null ) {
            count=count+1;
            if(node.left!=null) {
                count=count+1;
            }
            if(node.right!=null) {
                count=count+1;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        timcayBSTcon tree = new timcayBSTcon();
        int[] a = {5, 2, 4, 1, 3};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

        System.out.println(tree.BstCon(tree.root));

    }
}
