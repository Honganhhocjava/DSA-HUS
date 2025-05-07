package LeetCode;

import java.util.*;

public class checkLienthong {
    private int n , m;
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visted;
    private int[] parent;
    List<Integer> re = new ArrayList<>();

    public void input() {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt();
        m = sc.nextInt();
        visted = new boolean[n+1];
        parent = new int[n+1];
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

    public void setVisted() {
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }

    public void BFS(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visted[u] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<Integer> l = hashMap.get(v);
            if(l!=null) {
                for (int i = 0; i < l.size(); i++) {
                    int b = l.get(i);
                    if(!visted[b]) {
                        queue.add(b);
                        visted[b] = true;
                    }
                }
            }
        }
    }

    public void check() {
        BFS(1);
        for (int i = 1; i <=n ; i++) {
            if(!visted[i]) {
                System.out.println("Không");
                return;
            }
        }
           System.out.println("Liên thông");
    }

    public static void main(String[] args) {
        checkLienthong checkLienthong = new checkLienthong();
        checkLienthong.input();
        checkLienthong.check();
    }
}
