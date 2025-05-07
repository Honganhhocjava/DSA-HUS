package BaiTap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Deadend {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;
    public boolean isDeadEnd(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> la = new ArrayList<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            Node u = queue.poll();
            if(u.left == null && u.right == null){
                la.add(u.data);
            }
           list.add(u.data);
           if(u.left!=null) {
               queue.add(u.left);
           }
           if(u.right!= null) {
               queue.add(u.right);
           }

        }
        for (int i = 0; i < la.size(); i++) {
            if(list.contains(la.get(i) +1) && list.contains(la.get(i)-1)){
                return true;
            }
        }
        return false;
    }
}
