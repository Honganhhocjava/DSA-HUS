package BaiTap;
import java.util.*;
public class Dothi2p {
    private int n = 0;
    private int[] visited;
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        n = adj.size();
        visited = new int[n];
         setVisited();
        for (int i = 0; i < adj.size(); i++) {
            arrayLists.add(adj.get(i));
        }
        if(check()) {
            return true;
        }
        return false;

    }
    public void setVisited(){
        for (int i = 0; i < visited.length; i++) {
            visited[i] =-1;//chuaw too mauf
        }
    }

    public boolean Bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = 0;// mauf xanh
        while (!queue.isEmpty()) {
            int v = queue.poll();
            ArrayList<Integer> list = arrayLists.get(v);
            if(list != null) {
                for (int i = 0; i < list.size(); i++) {
                    int b = list.get(i);
                    if(visited[b] ==-1) {
                        visited[b] = 1 -visited[v];
                        queue.add(b);
                    }
                    else if(visited[b] == visited[v]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean check(){
        for (int i = 0; i <n ; i++) {
            if(visited[i] ==-1) {
                if(!Bfs(i)) {
                  return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Dothi2p dothi2p = new Dothi2p();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2,3)));
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(0,1,3)));
        list.add(new ArrayList<>(Arrays.asList(0,2)));
        System.out.println(dothi2p.isBipartite(list));
        }

}
