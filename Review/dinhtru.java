package Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class dinhtru {
    //dinh tru la dinh khi bo no di thi ta thu duoc nhieu thanh phan lien thong
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
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


    public void dinhtru(){
        int thanhphanlienthongbandau=0;
        resetVisited();
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                Dfs(i);
                thanhphanlienthongbandau++;
            }
        }


        int sodinhtru=0;
        for (int i = 1; i <= n; i++) {
            resetVisited();
            visited[i] =true;
            int thanhphanlienthonglucssau=0;
            for (int j = 1; j <=n ; j++) {

                if(!visited[j]){
                    Dfs(j);
                    thanhphanlienthonglucssau++;
                }
            }
            if(thanhphanlienthonglucssau > thanhphanlienthongbandau) {
                System.out.print(i +" ");

                sodinhtru++;

            }

        }
        System.out.println();
        System.out.println(sodinhtru);
    }

    public static void main(String[] args) {
        dinhtru dinhtru = new dinhtru();
        dinhtru.readFile();
        dinhtru.dinhtru();
    }
}
//input
//10 6
//5 4
//5 2
//10 2
//10 7
//5 3
//10 1
