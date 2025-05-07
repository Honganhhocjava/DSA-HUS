package BST;
import java.util.*;
public class Merga {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }
    public static void Merga(Node node1,Node node2) {
        List<Integer> list = new ArrayList<>();

        if(node1 == null) {
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node1);
        while (!q.isEmpty()) {
            Node e = q.poll();
            list.add(e.data);
            if(e.left !=null) {
                q.add(e.left);
            }
            if(e.right!=null) {
                q.add(e.right);
            }
        }
        q.add(node2);
        while (!q.isEmpty()) {
            Node e = q.poll();
            list.add(e.data);
            if(e.left !=null) {
                q.add(e.left);
            }
            if(e.right!=null) {
                q.add(e.right);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if(!set.contains(list.get(i))) {
                set.add(list.get(i));
            }
        }
        List<Integer> re = new ArrayList<>();
        for (int e :set) {
          re.add(e);
        }
        //Collections.sort(re);
        System.out.println(re);


    }

    public static void main(String[] args) {
        Merga tree = new Merga();
        Merga tree1 = new Merga();
        int a[] ={3,9,20,15,7};
        int b[] = {9,3,15,20,7};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            tree1.insert(b[i]);
        }
        Merga(tree.root, tree1.root);



    }
}
