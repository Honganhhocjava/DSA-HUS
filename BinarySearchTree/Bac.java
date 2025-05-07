package BST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Bac {
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

    public void delete(int data) {
        root = delete(root, data);
    }

    public boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // Nút cần xóa đã được tìm thấy

            // Trường hợp 1: Nút là lá
            if (isLeaf(node)) {
                return null;
            }

            // Trường hợp 2: Nút có một con
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Trường hợp 3: Nút có hai con
            Node maxNode = findMax(node.left);
            node.data = maxNode.data;
            node.left = delete(node.left, maxNode.data);
        }
        return node;
    }

    public Node findMax(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public int Bac(int data) {
        return Bac(root,data);
    }

    public int Bac(Node node, int data ) {
        if (node == null) {
           return -1;
        }
        Queue<Node > queue = new LinkedList<>();
       Queue<Integer> rank = new LinkedList<>();
        queue.offer(node);
        rank.offer(0);
        while (!queue.isEmpty()) {
            Node e = queue.poll();
            int r = rank.poll();
            if(e.data == data){
                return r;
            }
            if(e.left!=null) {
                queue.offer(e.left);
                rank.offer(r+1);

            }
            if(e.right!=null ) {
                queue.offer(e.right);
                rank.offer(r+1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Bac tree = new Bac();
        int[] a = {5,3,6,2,4,7};
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

        System.out.println("Trước khi xóa:");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println(tree.root.data);
        //tree.delete(3);

//        System.out.println("Sau khi xóa:");
//        tree.inorder(tree.root);
        System.out.println();
        int result = (tree.Bac(8));
        if (result == -1) { System.out.println("Không tìm thấy nút " + 8 + " trong cây."); } else { System.out.println("Bậc của nút " + 8+ " là: " + result); }
    }

    // Inorder traversal để kiểm tra cấu trúc cây
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        inorder(node.left);

        inorder(node.right);
    }
}
