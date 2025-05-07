package Hw6_22000070_NguyenThiAnh.BaiTap4;

import java.util.HashMap;

public class LongestSubarr {
    public static int lenOfLongestSubarr(int[] a, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (prefixSumMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixSumMap.get(sum - k));
            }

            prefixSumMap.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(lenOfLongestSubarr(a, k));
    }
}
