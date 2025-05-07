package LeetCode;

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

import java.util.ArrayList;
import java.util.*;

public class ThuatToanKruskal {
    class Node {
        int u,v,w;
        public Node(int u , int v,int w) {
            this.u = u;
            this.v= v;
            this.w=w;
        }
    }

    private int n ,m;
    private List<Node>  list = new ArrayList<>();
    private int[] parent;
    private int[] size;

    //khi dùng thuật toán kruskal thì tối ưu nhất chính là dùng danh sách cạnh

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n+1];
        size = new int[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            int z = Integer.parseInt(a[2]);
            Node newNode = new Node(x, y, z);
            list.add(newNode);

        }
    }
// vì dùng cái kruskal này phải dùng kiểm tra xem đồ thị có tạo chu trình hay không nên
// là ta sẽ bulid 3 hàm có săn của 1 thuật toán ktra chu trình

    public void memSet() {
        for (int i = 1 ;i <= n; i++) {
            parent[i] =i ;
            size[i] =1;
        }
    }

    public int find(int x) {
        if(x== parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }


    public boolean Onion(int a,int b) {
        a = find(a);
        b = find(b);
        if(a==b) {
            return false;
        }
        parent[a] = b;
//        }   if (size[a] < size[b]) {
//            parent[a] = b;
//            size[b] += size[a];
//        } else {
//            parent[b] = a;
//            size[a] += size[b];
//        }
        return true;
    }

    public void Kruskal() {
        List<Node> result = new ArrayList<>();// cái này để lưu cây khung nhỏ nhất
        int d = 0;//cái này để lưu chiều dài trọng số của cây khung
        // bước 1 phải sắp xếp theo thứ tự trọng số tăng dần
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        for (int i = 0; i < m; i++) {
            Node node = list.get(i);
            int dinh1= node.u;
            int dinh2 = node.v;
            int trongso = node.w;
            if(Onion(dinh1,dinh2)) {
                result.add(node);
                d += trongso;
            } if(result.size() == n-1) {
                break;
            }
        }

        if(result.size() != n-1) {
            System.out.println("Khong có cay khung ");
        }
        else {
            System.out.println("chieu dai cua khung cay la: " + d);
            System.out.println("Khung cay min theo thuật toán kruskal : ");
            for (int i = 0; i < result.size(); i++) {
                Node e = result.get(i);
                System.out.println(e.u + " " + e.v + " " + e.w);
            }
        }
    }

    public static void main(String[] args) {
        ThuatToanKruskal thuatToanKruskal = new ThuatToanKruskal();
        thuatToanKruskal.input();
        thuatToanKruskal.memSet();

        thuatToanKruskal.Kruskal();
    }
}
