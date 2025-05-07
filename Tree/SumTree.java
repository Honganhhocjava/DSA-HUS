package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumTree {
    class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public boolean sumTree(Node node) {
        int sum = node.data;
        int sumTree = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node cuNode = q.poll();
            if(cuNode.left != null) {
                sumTree += cuNode.left.data;
                q.add(cuNode.left);
            }
            if(cuNode.right != null) {
                sumTree += cuNode.right.data;
                q.add(cuNode.right);
            }
        }
        System.out.println(sumTree);

        return sum == sumTree;
    }

    public static void main(String[] args) {
        SumTree tree = new SumTree();
        Node node1 = tree.new Node(25);
        node1.left = tree.new Node(9);
//        node1.left.left = tree.new Node(10);
//        node1.left.right = tree.new Node(10);
        node1.right = tree.new Node(16);
       if( tree.sumTree(node1)) {
           System.out.println("True");
       } else {
           System.out.println("False");
       }


    }
}
