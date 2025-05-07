package BST;

import java.util.*;

public class SmallestSubtree {
    private  HashMap<Integer,List<Node>> hashMap = new HashMap<>();
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;


    public void subtreeWithAllDeepest(Node node) {
        List<Integer> result = countLvel(node);

        System.out.println(result);

    }

    public List<Integer> countLvel(Node node) {
        int r = 0;
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> rank = new LinkedList<>();
        queue.add(node);
        rank.add(r);
        while (!queue.isEmpty()) {
            Node e = queue.poll();
            int lvel = rank.poll();
            if(!hashMap.containsKey(lvel)) {
                hashMap.put(lvel,new ArrayList<>());
            }hashMap.get(lvel).add(e);

            if(e.left!=null) {
                queue.add(e.left);
                rank.offer(lvel+1);
            } if(e.right!=null) {
                queue.add(e.right);
                rank.offer(lvel+1);
            }
        }
        List<Node> integers = hashMap.get(hashMap.size()-1);
        List<Node> integers2 = hashMap.get(hashMap.size()-2);
        List<Integer> result = new ArrayList<>();
        if(integers2!=null) {
            for (int i = 0; i < integers2.size(); i++) {
                Node node1 = integers2.get(i);
                if (node1.left != null && node1.right != null) {
                    result.add(node1.data);
                }
            }
        }

        for (int i = 0; i < integers.size(); i++) {
            result.add(integers.get(i).data);
        }
        return result;

    }



    public static void main(String[] args) {
        SmallestSubtree tree = new SmallestSubtree();
        tree.root = tree.new Node(3);
        tree.root.left = tree.new Node(5);
        tree.root.right = tree.new Node(1);
        tree.root.left.left = tree.new Node(6);
        tree.root.left.right = tree.new Node(2);
        tree.root.left.right.right = tree.new Node(4);
        tree.root.left.right.left = tree.new Node(7);
        tree.root.right.left = tree.new Node(0);
        tree.root.right.right = tree.new Node(8);
        tree.subtreeWithAllDeepest(tree.root);
    }


}
