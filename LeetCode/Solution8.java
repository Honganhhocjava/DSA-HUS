package LeetCode;

import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class Solution8 {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    int u;

    public void input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
           u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);
            if (!hashMap.containsKey(u)) {
                hashMap.put(u, v);
            }
        }
    }

    public void Do() {
        // Kiểm tra nếu hashMap trống thì in ra -1
        if (hashMap.isEmpty()) {
            System.out.println(-1);
            return;
        }
        Set<Integer>  set = hashMap.keySet();
        int value = hashMap.get(u);
        for(int s :set) {
            if (hashMap.get(s) != value) {
                System.out.println(-1);
                return; // Thoát khỏi phương thức nếu phát hiện sự không đồng nhất
            }

        }
        System.out.println(value);
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        solution8.input();
        solution8.Do();
    }
}
