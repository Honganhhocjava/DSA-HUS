package BaiTap;

import java.util.*;

public class Timduongdixtoiy {
    // đầu vào là danh sach cạnh
    private int n , m ;
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private int[] parent;
    private boolean[] visted;
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n+1];
        visted = new boolean[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {

            int  u =sc.nextInt();
            int v =sc.nextInt();
            if(!hashMap.containsKey(u)) {
                hashMap.put(u,new ArrayList<>());
            } hashMap.get(u).add(v);
//            if(!hashMap.containsKey(v)) {
//                hashMap.put(v,new ArrayList<>());
//            } hashMap.get(v).add(u);
        }
    }
    public void setVisted() {
        Arrays.fill(visted,false);
    }


    public void Dfs(int u) {

        visted[u] = true;

        List<Integer> list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                parent[b] = u;
                if(!visted[b]) {
                    Dfs(b);
                }
            }
        }
    }

    public void find(int u , int v) {
        Dfs(u);
        if(!visted[v] ) {
            System.out.println("không có đường đi");
        }else {
            List<Integer> re = new ArrayList<>();
            while (v!=u) {
                re.add(v);
                v = parent[v];
            }
            re.add(u);
            Collections.reverse(re);
            System.out.println(re);

        }
    }

    public static void main(String[] args) {
        Timduongdixtoiy timduongdixtoiy = new Timduongdixtoiy();
        timduongdixtoiy.input();
        timduongdixtoiy.find(1,10);
    }
}
