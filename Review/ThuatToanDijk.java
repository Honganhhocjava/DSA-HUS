package Review;

import java.util.*;

public class ThuatToanDijk {
    class Node{
        int v,w;
        public Node(int v , int w) {
            this.v = v;
            this.w= w;
        }
    }

    private HashMap<Integer, List<Node>> hashMap = new HashMap<>();
    private int n , m;
    private int INF = Integer.MAX_VALUE;
    private int[] d;
    private int[] pa;
    public int[] djikstra(int[][] a, int x, int y) {
        n = a.length;
        m = a[0].length;
        d = new int[n+1];
        pa = new int[n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j] !=0) {
                    if(!hashMap.containsKey(i+1)){
                        hashMap.put(i+1,new ArrayList<>());
                    } hashMap.get(i+1).add(new Node(j+1,a[i][j]));

                    if(!hashMap.containsKey(j+1)){
                        hashMap.put(j+1,new ArrayList<>());
                    } hashMap.get(j+1).add(new Node(i+1,a[i][j]));
                }
            }
        }
        return Dijkstra(x,y);
    }

    public void setD(){
        Arrays.fill(d,INF);
    }
    public int[] Dijkstra(int u , int v){
        List<Integer> re = new ArrayList<>();

        setD();
      //  int dodai =0;
        d[u] = 0;
        pa[u] =u;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w,o2.w);
            }
        });
        priorityQueue.add(new Node(u,0));
        while (!priorityQueue.isEmpty()){
            Node e = priorityQueue.poll();
            int dinh1 = e.v;
            int trongso = e.w;
            if(trongso > d[dinh1]){
                continue;
            }

            List<Node > list = hashMap.get(dinh1);
            if(list!=null){
                for (int i = 0; i < list.size(); i++) {
                    Node node = list.get(i);
                    int dinh = node.v;
                    int chieudai=node.w;
                    if(d[dinh] > d[dinh1] +chieudai){
                        d[dinh] = d[dinh1] +chieudai;
                        priorityQueue.add(new Node(dinh,d[dinh]));
                       // dodai+=d[dinh];
                        pa[dinh] = dinh1;
                    }
                }
            }
        }
        System.out.println(d[v]);
        while (true){
            re.add(v);
            if(v==u) {
                break;
            }
          v=pa[v];
        }
        Collections.reverse(re);
        int[] result = new int[re.size()];
        for (int i = 0; i < re.size(); i++) {
            result[i] = re.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ThuatToanDijk thuatToanDijk = new ThuatToanDijk();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] result = thuatToanDijk.djikstra(graph, x, y);
        if (result.length == 0) {
            System.out.println("No path from " + x + " to " + y);
        } else {
            System.out.println("Shortest path from " + x + " to " + y + " is: " + Arrays.toString(result));
        }

    }
}
