package BST;

import java.util.ArrayList;
import java.util.List;

public class Path {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;


    public List<String> binaryTreePaths(Node node) {
        List<String> list = new ArrayList<>();
        DFS(node,"",list);
        return list;

    }

    public void DFS(Node node , String path,List<String> paths) {
        if(node==null) {
            return;
        }
        path +=node.data;
        if(node.left == null && node.right == null) {
            paths.add(path);
        } else {
            path +="->";
            DFS(node.left,path,paths);
            DFS(node.right,path,paths);
        }

    }

    public static void main(String[] args) {
        Path tree = new Path();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.right = tree.new Node(5);
       // tree.root.right.right = tree.new Node(4);
        System.out.println(tree.binaryTreePaths(tree.root));
    }
}
