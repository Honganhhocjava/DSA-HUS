package BaiTap;
import java.util.*;
public class TopoByKan {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    int parent[] ;
    boolean []vissted;
    ArrayList<Integer>  integerList= new ArrayList<>();
    int size;
    public ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
       size = adj.size();
        parent = new int[size];
        vissted = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, adj.get(i));
            }
        }
        Topo();
        return integerList;
    }

    public void setV() {
        Arrays.fill(vissted,false);
    }

    private void dfs(int u) {
        vissted[u] = true;
        List<Integer> neighbors = hashMap.get(u);
        if (neighbors != null) {
            for (int v : neighbors) {
                if (!vissted[v]) {
                    dfs(v);
                }
            }
        }
        integerList.add(u);
    }

    public void Topo(){
        for (int i = 0; i <size ; i++) {
            if(!vissted[i]) {
                dfs(i);
            }
        }
        Collections.reverse(integerList);
    }

    public static void main(String[] args) {
        TopoByKan topoByKan = new TopoByKan();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList()));
        list.add(new ArrayList<>(Arrays.asList(0)));
        list.add(new ArrayList<>(Arrays.asList(0)));
        list.add(new ArrayList<>(Arrays.asList(0)));
//        list.add(new ArrayList<>(Arrays.asList(0,1)));
//        list.add(new ArrayList<>(Arrays.asList(0,2)));
        System.out.println(topoByKan.topologicalSort(list));
    }
}
