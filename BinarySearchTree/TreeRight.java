package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRight {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public List<Integer> rightView(Node node) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node e = queue.poll();
                if(i == 0) {
                    list.add(e.data);
                }
                if(e.right != null) {
                    queue.add(e.right);
                }
                if(e.left!=null) {
                    queue.add(e.left);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeRight tree = new TreeRight();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.right = tree.new Node(4);
        System.out.println(tree.rightView(tree.root));
    }
}
