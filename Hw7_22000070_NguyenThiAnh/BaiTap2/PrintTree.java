package Hw7_22000070_NguyenThiAnh.BaiTap2;

import Hw7_22000070_NguyenThiAnh.BaiTap1.LinkedBinaryTree;

import java.util.Stack;

public class PrintTree extends ExpressionTree {
    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }
    public void buildFromPostfix(String[] postfix) {
        Stack<Node<String>> stack = new Stack<>();

        for (String token : postfix) {
            if (isOperator(token)) {
                Node<String> right = stack.pop();
                Node<String> left = stack.pop();
                Node<String> newNode = new Node<>(token, null, left, right);
                left.setParent(newNode);
                right.setParent(newNode);
                stack.push(newNode);
            } else {
                stack.push(new Node<>(token, null, null, null));
            }
        }
        this.root = stack.pop();
        this.n = postfix.length;
    }


    public static void main(String[] args) {
        String[] postfix = {"6", "3", "/", "2", "+", "7", "4", "-", "*"};
        PrintTree expressionTree = new PrintTree();
       expressionTree.buildFromPostfix(postfix);
        System.out.println("Preorder:");
        expressionTree.preorderPrint(expressionTree.getRoot());
        System.out.println();

        System.out.println("Inorder:");
        expressionTree.inorderPrint(expressionTree.getRoot());
        System.out.println();

        System.out.println("Postorder:");
        expressionTree.postorderPrint(expressionTree.getRoot());
        System.out.println();
    }
}
