package BaiTap;

import java.util.*;

public class DijkstraA {

    class Node {
        int v, w;

        Node(int first, int second) {
            this.v = first;
            this.w = second;
        }
    }

    private int INF = Integer.MAX_VALUE;
    private int[] d;

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<Node>> adjList, int src) {
        int n = adjList.size();
        d = new int[n];
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.fill(d, INF);
        d[src] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });

        priorityQueue.add(new Node(src, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int vertex = node.v;
            int distance = node.w;

            if (distance > d[vertex]) {
                continue;
            }

            List<Node> neighbors = adjList.get(vertex);
            if (neighbors != null) {
                for (Node neighbor : neighbors) {
                    int neighborVertex = neighbor.v;
                    int edgeWeight = neighbor.w;
                    if (d[neighborVertex] > d[vertex] + edgeWeight) {
                        d[neighborVertex] = d[vertex] + edgeWeight;
                        priorityQueue.add(new Node(neighborVertex, d[neighborVertex]));
                    }
                }
            }
        }

        for (int dist : d) {
            result.add(dist);
        }

        return result;
    }

    public static void main(String[] args) {
        DijkstraA dijkstraA = new DijkstraA();
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        // Tạo đồ thị từ đầu vào đã cung cấp
        int[][][] input = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};

        for (int i = 0; i < input.length; i++) {
            ArrayList<Node> neighbors = new ArrayList<>();
            for (int[] edge : input[i]) {
                neighbors.add(dijkstraA.new Node(edge[0], edge[1]));
            }
            adjList.add(neighbors);
        }

        // Đỉnh bắt đầu là 2
        int src = 2;

        // Kết quả mong đợi: [4, 3, 0]
        System.out.println(dijkstraA.dijkstra(adjList, src)); // Kết quả: [4, 3, 0]
    }
}
