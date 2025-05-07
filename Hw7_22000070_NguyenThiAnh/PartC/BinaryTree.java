package Hw7_22000070_NguyenThiAnh.PartC;

import java.util.*;

public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(nums.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nums.size()) {
            TreeNode curr = queue.poll();

            if (i < nums.size()) {
                curr.left = new TreeNode(nums.get(i++));
                queue.add(curr.left);
            }

            if (i < nums.size()) {
                curr.right = new TreeNode(nums.get(i++));
                queue.add(curr.right);
            }
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 6);
        TreeNode root = buildTree(nums);
        System.out.print("In-order traversal: ");
        printTree(root);
    }
}

