package Review;

import java.util.*;

public class Lienthongmanh {
    private HashMap<Integer, List<Integer>> hashMap1 = new HashMap<>();
    private HashMap<Integer,List<Integer>> hashMap2 = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();
    private int n , m;
    private boolean[] visted;
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visted=new boolean[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
            int u = Integer.parseInt(a[0]);
            int v= Integer.parseInt(a[1]);
            if(!hashMap1.containsKey(u)) {
                hashMap1.put(u,new ArrayList<>());
            } hashMap1.get(u).add(v);
            if(!hashMap2.containsKey(v)) {
                hashMap2.put(v,new ArrayList<>());
            } hashMap2.get(v).add(u);
        }
    }
    private void setVisted() {
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }
    public void dfs1(int u){
        visted[u] =true;
        List<Integer> list = hashMap1.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if(!visted[b]) {
                    dfs1(b);
                }
            }
        }
        System.out.print(u +" ");
        stack.push(u);
    }
    public void dfs2(int u){
        visted[u] =true;
        System.out.print(u + " ");
        List<Integer> list = hashMap2.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if(!visted[b]) {
                    dfs2(b);
                }
            }
        }
    }

    public void check() {
        int count =0;
        int count1=0;
        for (int i = 1; i <= n; i++) {
            if(!visted[i]) {
                dfs1(i);
                count++;
            }
        }
        System.out.println();
        setVisted();
       while (!stack.isEmpty()){
           int a = stack.pop();
           if(!visted[a]) {
               dfs2(a);
               System.out.println();
           }
       }
    }

    public static void main(String[] args) {
        Lienthongmanh lienthongmanh = new Lienthongmanh();
        lienthongmanh.input();
        lienthongmanh.check();
    }
}
//input
//8 9
//1 2
//2 3
//3 4
//4 1
//3 5
//5 6
//6 7
//7 8
//8 6