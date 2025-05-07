package Hw7_22000070_NguyenThiAnh.PartC;

import java.util.*;



    public class CompleteBinaryTree {
        static class TreeNode {
            int value;
            TreeNode left, right;

            TreeNode(int value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }

        public static TreeNode buildTree(List<Integer> arr) {
            if (arr == null || arr.isEmpty()) return null;

            TreeNode root = new TreeNode(arr.get(0));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int i = 1;
            while (!queue.isEmpty() && i < arr.size()) {
                TreeNode current = queue.poll();

                if (i < arr.size()) {
                    current.left = new TreeNode(arr.get(i++));
                    queue.add(current.left);
                }

                if (i < arr.size()) {
                    current.right = new TreeNode(arr.get(i++));
                    queue.add(current.right);
                }
            }

            return root;
        }

        public static void inOrderTraversal(TreeNode root) {
            if (root == null) return;

            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }

        public static void main(String[] args) {
            List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            TreeNode root = buildTree(arr);

            System.out.print("In-order traversal : ");
            inOrderTraversal(root);
        }
    }
