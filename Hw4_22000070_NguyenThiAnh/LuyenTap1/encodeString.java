package Hw4_22000070_NguyenThiAnh.LuyenTap1;


import java.util.Stack;

// Cho một sâu s chỉ gồm các ký tự viết thường, hãy viết hàm trả về chuỗi mã hóa của sâu này.
public class encodeString {
    public static String encodeStr(String str) {
        Stack stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() ; i++) {
            if(i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                count++;
            }else {
                stack.push(count);
                stringBuilder.append(str.charAt(i)).append(stack.pop());
                count=1;
            }

        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String str = "aaabbc";
        String encoded = encodeStr(str);
        System.out.println("Encoded string: " + encoded);
    }
}
