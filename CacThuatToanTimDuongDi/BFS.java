package BaiTap;
import java.util.*;
public class BFS {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    boolean []vissted;

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int size = adj.size();
        //parent = new int[size];
        vissted = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, adj.get(i));

            }
        }
        ArrayList<Integer> re = Bfs(V);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < re.size(); i++) {
            if (!result.contains(re.get(i))) {
                result.add(re.get(i));
            }
        }
        return result;

    }

    public void setV(){
        Arrays.fill(vissted,false);
    }

    public ArrayList<Integer> Bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(u);
        result.add(u);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            vissted[v] = true;
            List<Integer> list = hashMap.get(v);
            if(list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    int b = list.get(i);
                    result.add(b);
                    if(!vissted[b]) {
                        queue.add(b);
                        vissted[b] = true;
                    }

                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2,3,1)));
        list.add(new ArrayList<>(Arrays.asList(0)));
        list.add(new ArrayList<>(Arrays.asList(0, 4)));
        list.add(new ArrayList<>(Arrays.asList(0)));
        list.add(new ArrayList<>(Arrays.asList(2)));
        System.out.println(bfs.bfsOfGraph(0,list));
    }
}
