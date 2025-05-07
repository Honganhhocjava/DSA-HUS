package Graph;

import java.util.*;

// Đầu vào
//6 8 1 6
//1 2 7
//1 3 12
//2 3 2
//2 4 9
//3 5 10
//4 6 1
//5 4 4
//5 6 5

public class Dijkstra {
    // Áp dụng tìm đường đi ngắn nhất từ một đỉnh trong đồ thị đến đỉnh khác
    // Thuật toán này áp dụng được với đồ thị có hướng và đồ thị không hướng
    // Nhưng cần lưu ý trọng số của các cạnh không được là số âm
    // Thuật toán BFS cũng tìm đường đi ngắn nhất nhưng chỉ dùng cho đồ thị không có trọng số
    class Node {
        int v, w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private int n, m,s,t;
    private HashMap<Integer, List<Node>> hashMap = new HashMap<>();
    private final double INF = 1e9;
    private double[] duongdi;
    //muốn truy vết đường đi của thuật toán ta thêm 1 mảng
    private int[] parent ;

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();
        duongdi = new double[n + 1];
        parent = new int[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] a = sc.nextLine().trim().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            int z = Integer.parseInt(a[2]);
            if (!hashMap.containsKey(x)) {
                hashMap.put(x, new ArrayList<>());
            }
            hashMap.get(x).add(new Node(y, z));
        }

        Dijkstra(s,t);
    }

    // Khởi tạo mảng lưu khoảng cách đường đi = vô cùng
    public void setDuongdi() {
        for (int i = 0; i < duongdi.length; i++) {
            duongdi[i] = INF;
        }
    }

    public void Dijkstra(int s,int y) { // nếu đầu vào là 1 đỉnh s thì n duyệt hết tát cả đường đi giữa các đỉnh
        // muốn tìm đường đi từ đỉnh s đến 1 đỉnh khác thì ta thêm tham số truyền vào
        setDuongdi();
        duongdi[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        // Đẩy đỉnh nguồn vào
        q.add(new Node(s, 0));
        parent[s] = s;

        while (!q.isEmpty()) {
            // Lấy đỉnh có khoảng cách ngắn nhất ra khỏi hàng đợi
            Node e = q.poll();
            int dinh = e.v;
            int kc = e.w;
            // Nếu khoảng cách hiện tại lớn hơn khoảng cách tối thiểu đã biết, bỏ qua đỉnh này
            if (kc > duongdi[dinh]) {
                continue;
            }

            // Duyệt các đỉnh kề của đỉnh hiện tại
            List<Node> nodeList = hashMap.get(dinh);
            if (nodeList != null) {
                for (Node node : nodeList) {
                    int v = node.v;
                    int w = node.w;
                    if (duongdi[v] > duongdi[dinh] + w) {
                        duongdi[v] = duongdi[dinh] + w;
                        q.add(new Node(v, (int) duongdi[v]));
                        parent[v] = dinh;
                    }
                }
            }
        }
        System.out.println(duongdi[y]);
        List<Integer> re = new ArrayList<>();
        while (true) {
            re.add(y);
            if(y==s) {
                break;
            }
            y=parent[y];
        }
        Collections.reverse(re);
        System.out.println(re);

//        // In khoảng cách từ đỉnh bắt đầu đến các đỉnh khác
//        for (int i = 1; i <= n; i++) {
//            System.out.println("Distance from " + s + " to " + i + ": " + duongdi[i]);
//        }

    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.input();

    }
}
