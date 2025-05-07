package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level {
    class Node{
        int data;
       Node left,right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }




    public void level(Node node) {
        int i =0;
        List<Integer> result = new ArrayList<>();
        result.add(node.data);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cuNode = queue.poll();
            if (i %2 == 0) {
                if(cuNode.left != null) {
                    result.add(cuNode.left.data);
                    queue.add(cuNode.left);
                }
                if(cuNode.right != null) {
                    result.add(cuNode.right.data);
                    queue.add(cuNode.right);
                }
            }
            else{
                if(cuNode.right != null) {
                    result.add(cuNode.right.data);
                    queue.add(cuNode.right);
                }
                if(cuNode.left != null) {
                    result.add(cuNode.left.data);
                    queue.add(cuNode.left);
                }
                i++;
            }
        }
        for (int j = 0; j < result.size(); j++) {
            System.out.print(result.get(j) + " ");
        }
    }

    public static void main(String[] args) {
        Level tree = new Level();
        Node node1 = tree.new Node(1);
        node1.left = tree.new Node(3);
//          node1.left.left = tree.new Node(40);
//          node1.left.right = tree.new Node(60);
        node1.right = tree.new Node(2);
//        node1.right.left = tree.new Node(5);
//        node1.right.right = tree.new Node(4);
        tree.level(node1);


    }


}
