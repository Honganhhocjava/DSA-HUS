package LeetCode;

import java.util.*;

public class Solution6 {
    // BÀi toán như sau tìm 1 cái đồ thị ban đầu là đồ thị vô hướng k có chu trinh nhưng ngta đã
    // thêm chu trình vào để biến đồ thị có chu trình việc của mình là xóa đi cạnh thêm vào
    // ý tuowgr như sau ta dùng thuật toán dfs hoặc bfs để tìm chu trình của bài toán sau đó xóa đi
    // cạnh cuối của chu trình là được


    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private int[] parent;
    int n;
    int st,e;

    // Đọc đầu vào
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // Số lượng đỉnh
        int m = sc.nextInt();  // Số lượng cạnh
        visited = new boolean[n + 1];
        parent = new int[n +1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
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

    // Đặt lại trạng thái visited
    public void setVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] =false;
        }
    }

    // DFS để tính chiều cao của cây
    public boolean Dfs(int u) {
        visited[u] = true;
        List<Integer> list = hashMap.get(u);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                parent[b] = u;
                if (!visited[b]) {
                    if(Dfs(b)) {
                        return true;
                    }
                } else if(b!= parent[u]) {
                    st = u;
                    e=b;
                    return true;
                }
            }
        }
      return false;
    }

    public void bool() {
        if(Dfs(1)) {
            System.out.println(e + " " + st);
        }
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        solution6.input();
        solution6.bool();
    }

}
