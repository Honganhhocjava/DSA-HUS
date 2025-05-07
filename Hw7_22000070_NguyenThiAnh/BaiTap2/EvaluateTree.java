package Hw7_22000070_NguyenThiAnh.BaiTap2;

public class EvaluateTree extends  PrintTree{
    public double evaluate(Node<String> node) {
        if (node == null) return 0;

        if (node.getLeft() == null && node.getRight() == null) {
            return Double.parseDouble(node.getElement());
        }

        double leftValue = evaluate(node.getLeft());
        double rightValue = evaluate(node.getRight());

        String operator = node.getElement();

        switch (operator) {
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/":
                if (rightValue == 0) throw new ArithmeticException("Division by zero");
                return leftValue / rightValue;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    public static void main(String[] args) {
        EvaluateTree expressionTree = new EvaluateTree();
        String[] postfix = {"6", "3", "/", "2", "+", "7", "4", "-", "*"};
        expressionTree.buildFromPostfix(postfix);

        double result = expressionTree.evaluate(expressionTree.getRoot());
        System.out.println("Kết quả của biểu thức là: " + result);
    }
}
