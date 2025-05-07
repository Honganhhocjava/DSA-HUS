package Hw6_22000070_NguyenThiAnh.BaiTap5;

import java.util.HashSet;

public class LongestDupSubstring {
        public String longestDupSubstring(String s) {
            int left = 1;
            int right = s.length() - 1;
            String result = "";

            while (left <= right) {
                int mid = left + (right - left) / 2;
                String dup = getDuplicatedSubstring(s, mid);
                if (dup != null) {
                    result = dup;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }

        private String getDuplicatedSubstring(String s, int length) {
            HashSet<String> seen = new HashSet<>();
            for (int i = 0; i <= s.length() - length; i++) {
                String substring = s.substring(i, i + length);
                if (seen.contains(substring)) {
                    return substring;
                }
                seen.add(substring);
            }
            return "";
        }
        public static void main(String[] args) {
            LongestDupSubstring solution = new LongestDupSubstring();
            String s = "banana";
            System.out.println(solution.longestDupSubstring(s));
        }
}
