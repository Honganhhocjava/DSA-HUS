package BaiTap;

import java.util.*;

public class Dijkstra {
    class Node{
        int v ,  w;
        public Node(int v , int w) {
            this.v= v;
            this.w= w;
        }
    }
    private HashMap<Integer, List<Node>> hashMap = new HashMap<>();
    private int n;
    private int[] d ;
    private int[] parent;
    private int INF = Integer.MAX_VALUE;

    public int[] djikstra(int[][] a, int x, int y) {
        n = a.length;
        parent = new int[n+1];
        d = new int[n+1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j] !=0) {
                    if(!hashMap.containsKey(i+1)) {
                        hashMap.put(i+1,new ArrayList<>());
                    }hashMap.get(i+1).add(new Node(j+1,a[i][j]));

                    if(!hashMap.containsKey(j+1)) {
                        hashMap.put(j+1,new ArrayList<>());
                    }hashMap.get(j+1).add(new Node(i+1,a[i][j]));
                }
            }
        }
        return Dijktra(x,y);
    }

    public void setD() {
        for (int i = 0; i < parent.length; i++) {
            d[i] = INF;
        }

    }

    public int[] Dijktra(int u , int v) {
        List<Integer> result = new ArrayList<>();
       setD();
       d[u]= 0;
       parent[u] = u;
        PriorityQueue<Node>  priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w,o2.w);
            }
        });
        priorityQueue.add(new Node(u , 0));
        while (!priorityQueue.isEmpty()) {
            Node e = priorityQueue.poll();
            int dinh = e.v;
            int dd= e.w;
            if(dd > d[dinh]) {
                continue;
            }

            List<Node> list = hashMap.get(dinh);
            if(list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    Node node = list.get(i);
                    int dinh1= node.v;
                    int d2= node.w;
                    if(d[dinh1] > d[dinh] + d2) {
                        d[dinh1] = d[dinh] + d2;
                        priorityQueue.add(new Node(dinh1,d[dinh1]));
                        parent[dinh1] = dinh;
                    }
                }
            }
        }
        while (true) {
            result.add(v);
            if(v==u) {
                break;
            }
            v = parent[v];
        }
        Collections.reverse(result);
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        Dijkstra dij= new Dijkstra();
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
        int[] result = dij.djikstra(graph, x, y);
        if (result.length == 0) {
            System.out.println("No path from " + x + " to " + y);
        } else {
            System.out.println("Shortest path from " + x + " to " + y + " is: " + Arrays.toString(result));
        }
    }
}
