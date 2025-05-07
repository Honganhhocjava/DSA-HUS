package LeetCode;
import java.util.*;

public class Solution4 {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    int n;

    // Đọc đầu vào
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // Số lượng đỉnh
        int m = sc.nextInt();  // Số lượng cạnh
        visited = new boolean[n + 1];
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
    public int Dfs(int u) {
        int count = 0;
        visited[u] = true;
        List<Integer> list = hashMap.get(u);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if (!visited[b]) {
                    count = Math.max(count, Dfs(b) + 1);
                }
            }
        }
        return count;
    }

    // Tìm các gốc cây có chiều cao nhỏ nhất
    public void min() {
        int minHeight = Dfs(0);
        List<Integer> mhtRoots = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            setVisited();  // Đặt lại trạng thái visited
            int height = Dfs(i);
            if (height < minHeight) {
                minHeight = height;
                mhtRoots.clear();
                mhtRoots.add(i);
            } else if (height == minHeight) {
                mhtRoots.add(i);
            }
        }

        System.out.println(mhtRoots);
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.input();
        solution4.min();
    }
}
