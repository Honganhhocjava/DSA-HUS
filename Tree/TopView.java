package Tree;

import java.util.*;

public class TopView {
    class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            this.left=this.right = null;
        }
    }

    private Node root;
    class Pair{
        Node node;
        int d ;
        public Pair(Node node,int d) {
            this.node =node;
            this.d =d;
        }
    }


    public void topView(Node node) {
        List<Integer> re = new ArrayList<>();
        if(node == null) {
           return;
        }
        HashMap<Integer,Integer>  hashMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node,0));
        while (!queue.isEmpty()){
            Pair cuNode = queue.poll();
            Node cu = cuNode.node;
            int kc = cuNode.d;
            if(!hashMap.containsKey(kc)) {
                hashMap.put(kc,cu.data);
            }
            if(cu.left!=null) {
                queue.add(new Pair(cu.left,kc-1));
            }
            if(cu.right!=null) {
                queue.add(new Pair(cu.right,kc+1));
            }
        }
        Set<Integer> set = hashMap.keySet();
        for (int e : set) {
            re.add(e);
            Collections.sort(re);
        }
        for (int i = 0; i < re.size(); i++) {
            System.out.print(hashMap.get(re.get(i)) + " ");
        }
    }

    public static void main(String[] args) {
        TopView tree = new TopView();
        tree.root = tree.new Node(1); tree.root.left = tree.new Node(2); tree.root.right = tree.new Node(3); tree.root.left.left = tree.new Node(4); tree.root.left.right = tree.new Node(5); tree.root.right.right = tree.new Node(6); tree.root.left.right.right = tree.new Node(7); System.out.println("Top view of the binary tree is:"); tree.topView(tree.root);
    }
}
