package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TopoByDFS {
    private final HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private List<Integer> integerList = new ArrayList<>();
    private int n;

    public void readFile(String file) {
        try (Scanner sc = new Scanner(new FileReader(file))) {
            n = sc.nextInt();
            int m = sc.nextInt();
            visited = new boolean[n + 1];
            sc.nextLine();

            for (int i = 0; i < m; i++) {
                String[] edge = sc.nextLine().trim().split(" ");
                int v = Integer.parseInt(edge[0]);
                int s = Integer.parseInt(edge[1]);
               if(!hashMap.containsKey(v)) {
                   hashMap.put(v,new ArrayList<>());
               } hashMap.get(v).add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }
    }

    private void dfs(int u) {
        visited[u] = true;
        List<Integer> neighbors = hashMap.get(u);
        if (neighbors != null) {
            for (int v : neighbors) {
                if (!visited[v]) {
                    dfs(v);
                }
            }
        }
        integerList.add(u);
    }

    public void topo() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        Collections.reverse(integerList);
        System.out.println("Topological Order: " + integerList);
    }

    public static void main(String[] args) {
        TopoByDFS topoByDFS = new TopoByDFS();
        topoByDFS.readFile("topo.txt");
        topoByDFS.topo();
    }
}
