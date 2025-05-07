package LeetCode;

import Graph.BFS;

import java.sql.Struct;
import java.util.*;

public class Btap3 {
    //Tìm đường đi ngắn nhất trên đồ thị không có trọng số
    //- Tìm đường đi ngắn nhất từ đỉnh x đến đỉnh y trên đồ thị
    //không có trọng số, sử dụng thuật toán tìm kiếm theo chiều
    //rộng.
    //- In ra đường đi ngắn nhất từ x đến y
    private int n , m;
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visted;
    private int[] parent;

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
        }
    }

    public void setVisted() {
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }

    public void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visted[x] = true;
        while (!queue.isEmpty()) {
            int b = queue.poll();
            List<Integer> list = hashMap.get(b);
            if(list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    int dinh = list.get(i);
                    if(!visted[dinh]) {
                        parent[dinh] = b ;
                        queue.add(dinh);
                        visted[dinh] = true;
                    }
                }
            }
        }
    }


    public void check(int u , int v) {
        BFS(u);
        if(!visted[v]) {
            System.out.println("ko có đường đi");
        }
        List<Integer> re = new ArrayList<>();
        while (v!=u){
            re.add(v);
            v = parent[v];
        }
        re.add(u);
        Collections.sort(re);
        System.out.println(re);
    }

    public static void main(String[] args) {
        Btap3 btap3 = new Btap3();
        btap3.input();
        btap3.check(1,6);
    }
}

// đầu vào
//6 7
//1 2
//1 3
//2 4
//2 5
//3 5
//4 6
//5 6
