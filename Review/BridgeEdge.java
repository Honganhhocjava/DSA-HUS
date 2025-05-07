package Review;
import java.util.*;
public class BridgeEdge {
    class Node {
        int u, v;

        public Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    List<Node> canhcau = new ArrayList<>();
    private int n;
    private boolean[] vissted;

    public int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        n = adj.size();
        vissted = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> dinh = adj.get(i);
            for (int j = 0; j < dinh.size(); j++) {
                int b = dinh.get(j);
                canhcau.add(new Node(i, b));
            }
        }
        int thanhphanlienthongbandau = 0;
        setVissted();
        for (int i = 0; i < n; i++) {
            if (!vissted[i]) {
                DFS(i, adj);
                thanhphanlienthongbandau++;
            }
        }
        int socanhcau = 0;
        setVissted();
        int dem = 0;
        for (int j = 0; j < n; j++) {
            if (!vissted[j]) {
                dfs(adj, j, c, d);
                dem++;

            }
            if (dem > thanhphanlienthongbandau) {
                socanhcau++;
            }
        }
        if(socanhcau > 0) {
            return 1;
        }
        return 0;
    }

    public void setVissted() {
        Arrays.fill(vissted, false);
    }

    public void DFS(int u, ArrayList<ArrayList<Integer>> adj) {
        vissted[u] = true;
        ArrayList<Integer> list = adj.get(u);
        if (list != null) {
            for (int b : list) {
                if (!vissted[b]) {
                    DFS(b, adj);
                }
            }
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int u, int c, int d) {
        vissted[u] = true;
        ArrayList<Integer> list = adj.get(u);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if ((b == c && u == d) || (b == d && u == c)) {
                    continue;
                }
                if (!vissted[b]) {
                    dfs(adj, b, c, d);
                }
            }
        }
    }

    public static void main(String[] args) {
        BridgeEdge bridgeEdge = new BridgeEdge();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Số đỉnh (0, 1, 2, 3)
        int n = 5; // Số đỉnh
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Thêm các cạnh cho đồ thị vô hướng
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 3, 4);


        // In danh sách kề
        System.out.println(bridgeEdge.isBridge(5,adj,1,2));

    }

    // Phương thức thêm cạnh vào đồ thị vô hướng
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // Kết nối u → v
        adj.get(v).add(u); // Kết nối v → u (vì vô hướng)
    }
}
