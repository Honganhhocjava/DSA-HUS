package Review;

import java.util.*;

public class Demcactplt {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private int[] parent;
    private int n;

    public void readFile() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        visited = new boolean[n + 1];
        parent= new int[n+1];// Khởi tạo mảng visited với kích thước đúng

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
    public void bfs(int u){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            List<Integer> list = hashMap.get(v);
            if(list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    int b = list.get(i);
                    if(!visited[b]){
                        parent[b]  = v;
                        queue.add(b);
                        visited[b] = true;
                    }
                }
            }
        }
    }

    public int Dem(){
        int count = 0;
        for (int i = 0; i <n; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Demcactplt demcactplt = new Demcactplt();
        demcactplt.readFile();
        System.out.println(demcactplt.Dem());
    }
}

//input
//6 6
//0 1
//2 3
//2 4
//3 4
//3 5
//4 5

