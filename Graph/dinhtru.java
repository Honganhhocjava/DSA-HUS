package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//test
//10 6
//5 4
//5 2
//10 2
//10 7
//5 3
//10 1

public class dinhtru {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private int n;

    public void readFile() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        visited = new boolean[n + 1]; // Khởi tạo mảng visited với kích thước đúng

        for (int i = 0; i < m; i++) {
            String[] a = sc.nextLine().trim().split(" ");
            int v = Integer.parseInt(a[0]);
            int u = Integer.parseInt(a[1]);
            if (!hashMap.containsKey(v)) {
                hashMap.put(v, new ArrayList<>());
            }
            hashMap.get(v).add(u);

            if (!hashMap.containsKey(u)) {
                hashMap.put(u, new ArrayList<>());
            }
            hashMap.get(u).add(v);
        }
    }

    public void Dfs(int u) {
        visited[u] = true;
        List<Integer> list = hashMap.get(u);
        if (list != null) {
            for (int b : list) {
                if (!visited[b]) {
                    Dfs(b);
                }
            }
        }
    }

    public void resetVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public void dinhtru() {
        int initialComponentCount = 0;

        // Đếm số lượng thành phần liên thông ban đầu
        resetVisited();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                Dfs(i);
                initialComponentCount++;
            }
        }

        // Kiểm tra từng đỉnh xem có phải đỉnh trụ không
        int dinhtruCount = 0;
        for (int i = 1; i <= n; i++) {
            resetVisited();
            visited[i] = true; // Giả định đỉnh i bị loại bỏ
            int currentComponentCount = 0;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    Dfs(j);
                    currentComponentCount++;
                }
            }
            if (currentComponentCount > initialComponentCount) {
                System.out.print(i + " ");
                System.out.println();
                dinhtruCount++;
            }
        }
        System.out.println( "Số lượng đỉnh trụ " + dinhtruCount);
    }

    public static void main(String[] args) {
        dinhtru dinhtru = new dinhtru();
        dinhtru.readFile();
        dinhtru.dinhtru();
    }
}
