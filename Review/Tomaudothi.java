package Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Tomaudothi {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private int n, m;
    private int[] mau;
    private boolean[] visited;

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        mau = new int[n + 1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] c = sc.nextLine().trim().split(" ");
            int u = Integer.parseInt(c[0]);
            int v = Integer.parseInt(c[1]);
            hashMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            hashMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }

    // Kiểm tra xem đỉnh u có thể tô màu m1 hay không
    public boolean check(int u, int m1) {
        List<Integer> list = hashMap.get(u);
        if (list != null) {
            for (int b : list) {
                if (mau[b] == m1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Tô màu cho đỉnh u với màu m1 nếu có thể
    public void tomau(int u, int m1) {
        if (check(u, m1)) {
            mau[u] = m1;
            visited[u] = true;
        }
    }

    // Tìm số màu cần tối thiểu để tô toàn bộ đồ thị
    public int somaucanto() {
        int maubandau = 1;

        while (true) {
            boolean allColored = true;
            for (int u = 1; u <= n; u++) {
                if (mau[u] == 0) {
                   allColored = false;
                    tomau(u,maubandau);
                }
            }
            if (allColored) break;
                maubandau++;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(mau[i] + " ");
        }
        return maubandau - 1;
    }

    public static void main(String[] args) {
        Tomaudothi tomaudothi = new Tomaudothi();
        tomaudothi.input();
        System.out.println("\nSố màu cần tô: " + tomaudothi.somaucanto());
    }
}
//6 8
// 1 2
// 1 3
// 2 3
// 2 4
// 2 5
// 3 5
// 4 6
// 5 6