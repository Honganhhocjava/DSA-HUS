package LeetCode;

import java.util.*;

public class dij {
    class Node {
        int u, v;
        public Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private HashMap<Integer, List<Node>> hashMap = new HashMap<>();
    private int[] distance;
    private int INF = Integer.MAX_VALUE;
    private int[] pa;
    private List<Integer> resultList;

    public int[] djikstra(int[][] a, int x, int y) {
        int n = a.length;
        distance = new int[n];
        pa = new int[n + 1];
        resultList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    if (!hashMap.containsKey(i)) {
                        hashMap.put(i, new ArrayList<>());
                    }
                    hashMap.get(i).add(new Node(j, a[i][j]));
                    if (!hashMap.containsKey(j)) {
                        hashMap.put(j, new ArrayList<>());
                    }
                    hashMap.get(j).add(new Node(i, a[i][j]));
                }
            }
        }
        return Dijkstra(x - 1, y - 1);
    }

    public int[] Dijkstra(int x, int y) {
        List<Integer> re = new ArrayList<>();

        Arrays.fill(distance, INF);
        distance[x] = 0;
        pa[x] = x;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.v, o2.v);
            }
        });
        priorityQueue.add(new Node(x, 0));
        while (!priorityQueue.isEmpty()) {
            Node e = priorityQueue.poll();
            int dinh = e.u;
            int trongso = e.v;
            if (trongso > distance[dinh]) {
                continue;
            }

            List<Node> nodeList = hashMap.get(dinh);
            if (nodeList != null) {
                for (Node node : nodeList) {
                    int a = node.u;
                    int b = node.v;
                    if (distance[a] > distance[dinh] + b) {
                        distance[a] = distance[dinh] + b;
                        priorityQueue.add(new Node(a, distance[a]));
                        pa[a] = dinh;
                    }
                }
            }
        }
        while (true) {
            re.add(y);
            if (y == x) {
                break;
            }
            y = pa[y];
        }
        Collections.reverse(re);
        for (int node : re) {
            resultList.add(node + 1); // Chuyển đổi lại về 1-based index
        }
        int[] array = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            array[i] = resultList.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        dij dij = new dij();
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
// đầu vào
//5
//0 10 0 0 3
//0 0 2 0 4
//0 0 0 9 0
//0 0 7 0 0
//0 1 8 0 0
//1 3