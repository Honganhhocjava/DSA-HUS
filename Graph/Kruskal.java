package Graph;
import java.util.*;


// input
//6 9
//1 2 12
//1 3 4
//2 3 1
//2 4 5
//2 5 3
//3 5 2
//4 5 3
//4 6 10
//5 6 8

public class Kruskal {
    class Node {
        int u, v, w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private int n, m;
    private int[] parent;
    private int[] size;
    private List<Node> list = new ArrayList<>();

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] a = sc.nextLine().trim().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            int z = Integer.parseInt(a[2]);
            Node newNode = new Node(x, y, z);
            list.add(newNode);
        }
    }

    public void makeSet() {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public boolean Union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        if (size[a] < size[b]) {
            parent[a] = b;
            size[b] += size[a];
        } else {
            parent[b] = a;
            size[a] += size[b];
        }
        return true;
    }

    // Thuật toán Kruskal
    public void Kruskal() {
        List<Node> result = new ArrayList<>();
        int d = 0;

        // Sắp xếp các cạnh theo trọng số
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        // Duyệt qua các cạnh và thêm vào cây khung nếu không tạo chu trình
        for (int i = 0; i < m; i++) {
            Node e = list.get(i);
            if (Union(e.u, e.v)) {
                result.add(e);
                d += e.w;
            }
            // Nếu đã có đủ n-1 cạnh thì dừng
            if (result.size() == n - 1) {
                break;
            }
        }

        // Kiểm tra và in kết quả
        if (result.size() != n - 1) {
            System.out.println("No");
        } else {
            System.out.println( " MST" + d);
            for (Node e : result) {
                System.out.println(e.u + " " + e.v + " " + e.w);
            }
        }
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        kruskal.input();
        kruskal.makeSet();
        kruskal.Kruskal();
    }
}
