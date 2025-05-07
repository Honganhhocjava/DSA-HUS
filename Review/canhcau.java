package Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class canhcau {
    class Node{
        int u ,  v;
        public Node(int u , int v) {
            this.u = u;
            this.v = v;
        }
    }
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private List<Node> canh = new ArrayList<>();
    // canh cau thi dung danh sach canh
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
            canh.add(new Node(u,v));
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


    public void canhcau() {
        resetVisited();
        int sothanhphanlienthongbandau=0;
        for (int i = 1; i <=n ; i++) {
            if(!visited[i]) {
                Dfs(i);
                sothanhphanlienthongbandau++;
            }
        }
        //duyet qua tung canh cua dothi
       int canhcauso=0;
        for (int i = 0; i < canh.size(); i++) {
            Node canhcau = canh.get(i);
            int x = canhcau.u; //dinh dau tien cua canh
            int y = canhcau.v;//dinh thu 2 cua canh
            //loai bo canh xy khoi do thi
            resetVisited();
            int dem = 0;
            for (int j = 1; j <= n; j++) {
                if(!visited[j]){
                    dfs(j,x,y);
                    dem++;
                }
            }

            if(dem > sothanhphanlienthongbandau) {
                System.out.println(x +" " + y);
                canhcauso++;
            }
        }
        System.out.println();
        System.out.println("so luong canh cau: " + canhcauso);
    }
    // tao dfs moi khong et dinh xy de
    public void dfs(int u , int s,int t) {
        visited[u] = true;
        List<Integer> list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if ((b == s && u == t) || (b == t && u == s)) {
                    continue;
                }
                if (!visited[b]) {
                    dfs(b, s, t);
                }
            }
        }
    }

    public static void main(String[] args) {
        canhcau canhcau = new canhcau();
        canhcau.readFile();
        canhcau.canhcau();
    }
}
//input
//10 8
//10 9
//10 8
//10 3
//10 4
//5 3
//10 1
//5 1
//5 4