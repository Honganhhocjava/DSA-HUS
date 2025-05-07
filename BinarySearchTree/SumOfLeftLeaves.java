package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumOfLeftLeaves {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public int sumOfLeftLeaves(Node node) {
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                Node e = queue.poll();
                if(i==0) {
                    list.add(e);
                }
                if(e.left!=null) {
                    queue.offer(e.left);
                }
                if(e.right!=null) {
                    queue.offer(e.right);
                }
            }
        }

        int sum =0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).left == null && list.get(i).right == null && list.get(i) != root) {
                sum+= list.get(i).data;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves tree = new SumOfLeftLeaves();
        tree.root = tree.new Node(3);
        tree.root.left = tree.new Node(9);
        tree.root.right = tree.new Node(20);
        tree.root.right.left = tree.new Node(15);
        tree.root.right.right = tree.new Node(7);

        System.out.println(tree.sumOfLeftLeaves(tree.root));
    }
}
