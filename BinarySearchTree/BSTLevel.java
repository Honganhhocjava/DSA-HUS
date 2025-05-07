package BST;

import java.util.*;

public class BSTLevel {
    class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    private Node root;

    public static List<List<Integer>> levelOrder(Node node) {
        HashMap<Integer,List<Integer>> result = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> rank = new LinkedList<>();
        int r = 0;
        queue.offer(node);
        rank.offer(r);
        while (!queue.isEmpty()) {
            Node e = queue.poll();
            int level = rank.poll();
            if(!result.containsKey(level)) {
                result.put(level,new ArrayList<>());
            } result.get(level).add(e.data);

            if(e.left!=null) {
                queue.offer(e.left);
                rank.offer(level+1);
            }
            if(e.right!=null) {
                queue.offer(e.right);
                rank.offer(level+1);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            list.add(result.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        BSTLevel tree = new BSTLevel();
        tree.root = tree.new Node(3);
        tree.root.left = tree.new Node(9);
        tree.root.right = tree.new Node(20);
        tree.root.right.left = tree.new Node(15);
        tree.root.right.right = tree.new Node(7);
        System.out.println(levelOrder(tree.root));


    }
}
