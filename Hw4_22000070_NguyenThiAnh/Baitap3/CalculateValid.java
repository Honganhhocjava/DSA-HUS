package Hw4_22000070_NguyenThiAnh.Baitap3;

import java.util.Stack;

public class CalculateValid {
    public double evaluateExp(String exp) {
        exp = exp.trim();
        Stack<Double> stack2 = new Stack<>(); // Stack số
        Stack<Character> stack3 = new Stack<>(); // Stack toán tử

        for (int i = 0; i < exp.length(); i++) {
            char current = exp.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                stack3.push(current); // Thêm dấu ngoặc mở vào stack toán tử
            } else if (Character.isDigit(current) || current == '.') {
                double num = 0;
                double decimalFactor = 1;
                boolean isDecimal = false;

                while (i < exp.length() && (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.')) {
                    if (exp.charAt(i) == '.') {
                        isDecimal = true; // Bắt đầu phần thập phân
                    } else {
                        if (isDecimal) {
                            decimalFactor *= 0.1;
                            num += Character.getNumericValue(exp.charAt(i)) * decimalFactor;
                        } else {
                            num = num * 10 + Character.getNumericValue(exp.charAt(i));
                        }
                    }
                    i++;
                }
                i--; // Lùi lại một vị trí để không bỏ qua ký tự tiếp theo
                stack2.push(num); // Đưa số vào stack số
            } else if (current == ')' || current == '}' || current == ']') {
                // Khi gặp dấu ngoặc đóng, tính toán các biểu thức bên trong
                while (!stack3.isEmpty() && (stack3.peek() != '(' && stack3.peek() != '{' && stack3.peek() != '[')) {
                    calculate(stack2, stack3.pop());
                }
                stack3.pop(); // Bỏ dấu ngoặc mở khỏi stack
            } else if (current == '+' || current == '-' || current == '*' || current == '/') {
                // Toán tử, xử lý độ ưu tiên
                while (!stack3.isEmpty() && precedence(stack3.peek()) >= precedence(current)) {
                    calculate(stack2, stack3.pop());
                }
                stack3.push(current); // Thêm toán tử vào stack toán tử
            }
        }

        // Tính toán các toán tử còn lại trong stack
        while (!stack3.isEmpty()) {
            calculate(stack2, stack3.pop());
        }

        return stack2.pop(); // Kết quả cuối cùng
    }

    // Hàm tính toán với hai toán hạng từ stack2
    private void calculate(Stack<Double> stack2, char operator) {
        double b = stack2.pop();
        double a = stack2.pop();

        switch (operator) {
            case '+':
                stack2.push(a + b);
                break;
            case '-':
                stack2.push(a - b);
                break;
            case '*':
                stack2.push(a * b);
                break;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Không thể chia cho 0.");
                }
                stack2.push(a / b);
                break;
        }
    }

    // Hàm xác định độ ưu tiên của toán tử
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        CalculateValid calculateValid = new CalculateValid();

        String expression1 = "((50 - ((8-4)*(2+3))) + (3*4))";
        System.out.println(calculateValid.evaluateExp(expression1));  // Kết quả đúng là 42.0
    }
}
