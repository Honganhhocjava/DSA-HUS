package Hw7_22000070_NguyenThiAnh.BaiTap3;

import Hw7_22000070_NguyenThiAnh.BaiTap1.LinkedBinaryTree;

import java.util.Stack;

public class ArithmeticExpression extends LinkedBinaryTree{

    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    public static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    public static String infixToPostfix(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        String[] tokens = infix.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {

                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                postfix.append(token).append(" ");
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }


    public void buildFromPostfix(String postfix) {
        Stack<Node<String>> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                Node<String> right = stack.pop();
                Node<String> left = stack.pop();

                Node<String> operatorNode = new Node<>(token, null, left, right);

                left.setParent(operatorNode);
                right.setParent(operatorNode);

                stack.push(operatorNode);
            } else {
                stack.push(new Node<>(token, null, null, null));
            }
        }

       root = stack.pop();
    }


    private void printLinkedTree(LinkedBinaryTree.Node<String> node, int level) {
        if (node == null) {
            return;
        }

        printLinkedTree(node.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(node.getElement());

        printLinkedTree(node.getLeft(), level + 1);
    }

    public void printTree() {
        printLinkedTree(root, 0);
    }

    public static void main(String[] args) {
        String infixExpression = "( 6 / 3 + 2 ) * ( 7 - 4 )";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        ArithmeticExpression tree = new ArithmeticExpression();
        tree.buildFromPostfix(postfixExpression);

        System.out.println("\nCây nhị phân in theo chiều ngang:");
        tree.printTree();
    }
}
