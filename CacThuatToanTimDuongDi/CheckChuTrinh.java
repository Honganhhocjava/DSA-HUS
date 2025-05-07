package BaiTap;
import java.util.*;
public class CheckChuTrinh {


    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    int parent[] ;
    boolean []vissted;
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int size = adj.size();
        parent = new int[size];
        vissted = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, adj.get(i));

            }
        }
        for (int i = 0; i < size; i++) {
            if (!vissted[i]) {
                if (Dfs(i)) {
                    return true;
                }
            }
        }
        return false;
    }



    public void SetVi() {
        Arrays.fill(vissted,false);
    }
    public boolean Dfs(int u) {

        vissted[u]=true;
        List<Integer> list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                parent[b] =u;
                if(!vissted[b]) {
                    if(Dfs(b)) {
                        return true;
                    }
                }
                if(b != parent[u] ) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckChuTrinh countChuTrinh = new CheckChuTrinh();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(0, 2, 4)));
        list.add(new ArrayList<>(Arrays.asList(1, 3)));
        list.add(new ArrayList<>(Arrays.asList(2, 4)));
        list.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(countChuTrinh.isCycle(list));
    }

}
