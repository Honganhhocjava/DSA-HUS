package BaiTap;
import java.util.*;
public class DemChuTrinh {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    int parent[] ;
    int []vissted;


    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int size = adj.size();
        parent = new int[size];
        vissted = new int[size +1];
        for (int i = 0; i < size; i++) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, adj.get(i));

            }
        }
      return Dfs(0);
    }
    public void setv(){
        Arrays.fill(vissted,0);
    }
    
    public boolean Dfs(int u) {
        vissted[u] = 1;
        List<Integer> l = hashMap.get(u);
        if(l!=null) {
            for (int i = 0; i <l.size() ; i++) {
                int b = l.get(i);
                if(vissted[b] ==0) {
                    if (Dfs(b)) {
                        return true;
                    }
                }
                if(vissted[b] ==1) {
                    return true;
                }
            }
        }
        vissted[u] =2;
        return false;
    }

    public static void main(String[] args) {
        DemChuTrinh demChuTrinh = new DemChuTrinh();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(3)));
        list.add(new ArrayList<>(Arrays.asList(3)));
        System.out.println(demChuTrinh.isCyclic(list));
    }
    
}
