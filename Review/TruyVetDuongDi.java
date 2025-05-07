package Review;

import java.util.*;

public class TruyVetDuongDi {
    // dau vao la danh sach ke
    private boolean[] vissted;
    private int[] parent;
    public ArrayList<Integer> truyvet(ArrayList<ArrayList<Integer>> hashMap,int u , int v) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = hashMap.size();
        vissted = new boolean[n];
        parent = new int[n];
        bfs(hashMap,u);
        if(!vissted[v]) {
            return null;
        } else {
            while (v!=u) {
                result.add(v);
                v=parent[v];
            }
            result.add(u);
            Collections.reverse(result);
        }
        return result;

    }
    public void setVissted() {
        Arrays.fill(vissted,false);
    }
    public void dfs(ArrayList<ArrayList<Integer>> hashMap , int u){
        vissted[u] = true;
        ArrayList<Integer> list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if(!vissted[b]) {
                    parent[b] = u;
                    dfs(hashMap,b);
                }
            }
        }
    }

    public void bfs(ArrayList<ArrayList<Integer>> hashMap , int u){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        vissted[u] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            ArrayList<Integer> list = hashMap.get(v);
            if(list!=null) {
                for (int i = 0; i <list.size() ; i++) {
                    int b = list.get(i);
                    if(!vissted[b]) {
                        parent[b] =v;
                      queue.add(b);
                      vissted[b] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TruyVetDuongDi truyVetDuongDi = new TruyVetDuongDi();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(0,2,3)));
        list.add(new ArrayList<>(Arrays.asList(1,5,6)));
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(6,7,9)));
        list.add(new ArrayList<>(Arrays.asList(2,6)));
        list.add(new ArrayList<>(Arrays.asList(2,5,4)));
        list.add(new ArrayList<>(Arrays.asList(4,8)));
        list.add(new ArrayList<>(Arrays.asList(7)));
        list.add(new ArrayList<>(Arrays.asList(4)));
        System.out.println(truyVetDuongDi.truyvet(list,0,9));


    }

}
