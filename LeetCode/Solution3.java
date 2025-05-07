package LeetCode;

import java.util.*;

public class Solution3 {
    //bai nay giong kieu la sap xep cac khoa hoc theo thu tu phai hoc mon nay roi moi den mon kia
    // dieu nay giong voi kieu sap xep topo cho 1 do thi co huong
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private int[] deGree;
    int n ;
    private List<Integer> result =new ArrayList<>();
    private List<Integer> result1 =new ArrayList<>();

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n+1];
        deGree = new int[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
            int v = Integer.parseInt(a[0]);
            int u = Integer.parseInt(a[1]);
            if (!hashMap.containsKey(v)) {
                hashMap.put(v, new ArrayList<>());
            }
            hashMap.get(v).add(u);
            deGree[u]++;
        }
    }

    //cach1 dung DFs
    public void Dfs(int u) {

        visited[u] = true;
        List<Integer> list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if(!visited[b]) {
                    Dfs(b);
                }
            }
        }
        result.add(u);
    }

    public void solution() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Dfs(i);
            }
        }

        System.out.println(result);
    }

    // Cach 2 dung thuat toans Kanh
    public void Kanh() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deGree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result1.add(u);
            List<Integer> list = hashMap.get(u);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    int b = list.get(i);
                    deGree[b]--;
                    if (deGree[b] == 0) {
                        queue.add(b);
                    }
                }
            }
        }
        Collections.reverse(result1);
        System.out.println(result1);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.input();
        System.out.println("Cach1");
        solution3.Kanh();
        System.out.println("Cach2");
        solution3.solution();
    }
}
