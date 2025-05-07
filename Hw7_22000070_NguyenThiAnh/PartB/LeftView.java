package Hw7_22000070_NguyenThiAnh.PartB;
import java.util.*;

// Bạn được cung cấp gốc của một cây nhị phân. Nhiệm vụ của bạn là trả về góc nhìn bên trái của cây nhị phân.
// Góc nhìn bên trái của một cây nhị phân là tập hợp các nút có thể nhìn thấy khi cây được nhìn từ phía bên trái.
public class LeftView {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node root;
    public int[] leftView() {
        if (root == null) {
            return new int[0];
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        LinkedList<Integer> leftViewNodes = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                if (i == 0) {
                    leftViewNodes.add(currentNode.data);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        int[] result = new int[leftViewNodes.size()];
        for (int i = 0; i < leftViewNodes.size(); i++) {
            result[i] = leftViewNodes.get(i);
        }

        return result;
    }

    public static void main(String args[]) {
        LeftView tree = new LeftView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(4);
        tree.root.right.left.right = new Node(5);

        int[] b = tree.leftView();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
