package reviewMidterm.HashSet;

import java.util.HashSet;

public class FindLongest {
    public static int findLongest(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNode = num;
                int currentStreak = 1;
                while (set.contains(currentNode + 1)) {
                    currentNode += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }



        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        int n = arr.length;
        System.out.println("Độ dài dãy liên tiếp dài nhất là: " + findLongest(arr, n));
    }
}
