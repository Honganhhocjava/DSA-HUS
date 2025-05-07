package BST;

import java.util.ArrayList;
import java.util.List;

public class SumofRootToLeaves {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;
    public int Sum(Node node) {
        List<String> list = new ArrayList<>();
        Dfs(node,"",list);
       int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum+=Integer.parseInt(list.get(i));
        }
        return sum;
    }

    public void Dfs(Node node , String list, List<String> lists) {
        if(node == null) {
            return;
        }
        list +=node.data;

        if(node.left == null && node.right == null) {
            lists.add(list);
        }
        else {
            Dfs(node.left,list,lists);
            Dfs(node.right,list,lists);
        }

    }

    public static void main(String[] args) {
        SumofRootToLeaves tree = new SumofRootToLeaves();
        tree.root = tree.new Node(4);
        tree.root.left = tree.new Node(9);
        tree.root.right = tree.new Node(0);
        tree.root.left.left = tree.new Node(5);
        tree.root.left.right = tree.new Node(1);
        System.out.println(tree.Sum(tree.root));
    }
}
