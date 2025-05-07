
package LeetCode;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

class Solution {
    private Map<Node, Node> visited;

    public Solution() {
        this.visited = new HashMap<>();
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Nếu đỉnh đã được sao chép, trả về đỉnh sao chép
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Tạo một đỉnh mới với giá trị giống đỉnh gốc
        Node newNode = new Node(node.val);

        // Đánh dấu đỉnh gốc là đã được sao chép và thêm vào bảng visited
        visited.put(node, newNode);

        // Đệ quy sao chép tất cả các đỉnh kề
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }

    // Hàm hỗ trợ để xây dựng đồ thị từ danh sách kề
    public Node buildGraph(int[][] adjList) {
        Node[] nodes = new Node[adjList.length];

        // Tạo tất cả các đỉnh
        for (int i = 0; i < adjList.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        // Thiết lập các đỉnh kề cho mỗi đỉnh dựa trên danh sách kề
        for (int i = 0; i < adjList.length; i++) {
            for (int neighbor : adjList[i]) {
                nodes[i].neighbors.add(nodes[neighbor - 1]); // Chuyển từ chỉ số bắt đầu từ 1 sang bắt đầu từ 0
            }
        }

        return nodes[0]; // Trả về đỉnh đầu tiên trong danh sách kề
    }

    // Hàm hỗ trợ để in ra đồ thị
    public List<List<Integer>> printGraph(Node node) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Node> visitedSet = new HashSet<>();

        // Dùng DFS để in ra đồ thị
        dfs(node, visitedSet, result);

        return result;
    }

    private void dfs(Node node, Set<Node> visitedSet, List<List<Integer>> result) {
        if (node == null || visitedSet.contains(node)) return;

        visitedSet.add(node);

        List<Integer> neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            neighbors.add(neighbor.val);
        }
        result.add(neighbors);

        // Đệ quy thăm các đỉnh kề
        for (Node neighbor : node.neighbors) {
            dfs(neighbor, visitedSet, result);
        }
    }

    // Hàm main để chạy ví dụ
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Xây dựng đồ thị từ danh sách kề
        int[][] adjList = {
                {2, 4},  // Đỉnh 1 kề với đỉnh 2 và 4
                {1, 3},  // Đỉnh 2 kề với đỉnh 1 và 3
                {2, 4},  // Đỉnh 3 kề với đỉnh 2 và 4
                {1, 3}   // Đỉnh 4 kề với đỉnh 1 và 3
        };

        // Xây dựng đồ thị gốc từ adjList
        Node node = solution.buildGraph(adjList);

        // Sao chép đồ thị
        Node clonedGraph = solution.cloneGraph(node);

        // In ra đồ thị sao chép
        List<List<Integer>> result = solution.printGraph(clonedGraph);

        // In kết quả
        System.out.println("Sao chép đồ thị:");
        for (List<Integer> neighbors : result) {
            System.out.println(neighbors);
        }
    }
}
