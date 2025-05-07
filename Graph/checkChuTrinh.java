package Graph;

import java.util.*;


public class checkChuTrinh {
    int n ,m , start, end;
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private int[] color;
    private int[] inDegree;
    // nếu không muốn DFS có đầu vào là 1 đỉnh và 1 parent thì ta thêm 1 mảng parent vào
   private int[] parent ;
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        color = new int[n + 1];
        inDegree = new int[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] a = sc.nextLine().trim().split(" ");
            int u = Integer.parseInt(a[0]);
            int v = Integer.parseInt(a[1]);
            if (!hashMap.containsKey(u)) {
                hashMap.put(u, new ArrayList<Integer>());
            }
            hashMap.get(u).add(v);
            inDegree[v]++;

            // xét đồ thị có hướng nên không thêm cạnh ngược nữa

//            if(!hashMap.containsKey(v)) {
//                hashMap.put(v,new ArrayList<Integer>());
//            }
//            hashMap.get(v).add(u);
//        }
        }
    }

    public void setVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    // đồ thị không hướng(vô hướng)

//    public boolean Dfs(int u , int par) {
//        visited[u] = true;
//        List<Integer> list = hashMap.get(u);
//        if(list!= null) {
//        for (int i = 0; i < list.size(); i++) {
//            int b = list.get(i);
//            if(!visited[b]) {
//               if(Dfs(b,u)) {
//                   return true;
//               }
//            } else if(b!= par) {
//                return true;
//            }
//            }
//
//        }
//        return false;
//
//    }



    public boolean DfsWParent(int u) {
        visited[u]  = true;
        List<Integer> list= hashMap.get(u);
        if(list!= null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if(!visited[b]) {
                 parent[b] = u;
                 if(DfsWParent(b)) {
                     return true;
                 }
                }
                else if(b!= parent[u]) {
                    start = u;
                    end = b;
                    return true;
                }
            }
        } return false;
    }

    //sử dụng bfs cho đồ thị vô hướng
    public boolean Bfs(int u) {
        visited[u] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        while (!queue.isEmpty()) {
            int p = queue.poll();
                List<Integer> list = hashMap.get(p);
                if(list!= null) {
                    for (int i = 0; i < list.size(); i++) {
                        int b = list.get(i);
                        if (!visited[b]) {
                            queue.add(b);
                            visited[b] = true;
                            parent[b] = p;
                        } else if (b != parent[p]) {
                            start = p;
                            end = b;
                            return true;
                        }

                    }
                }
        }
            return false;
    }

    // Lưu ý : không dùng thuật toán dfs cho đồ thị có hướng
    // Muốn dùng thì ta phải dùng 1 mảng để tô màu các trạng thái cảu mỗi đỉnh khi dược thăm



    public boolean DFS(int u) {
        color[u] = 1;
        List<Integer> list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int v = list.get(i);
                if(color[v]==0) {// chưa thăm
                    if(DFS(v)) {
                        return true;
                    }
                    parent[v] = u;
                } else if(color[v] ==1) {// đang có đường đi từ u đến v rùi mà h có đườn đi từ v đến u
                    return true;
                }
            }
        }
        color[u] = 2;// đã thăm xong
        return false;

    }
    // áp dụng với đồ thị có hướng



    // thuật toán Kanh. Do thuật toán Kanh không thể dùng cho
    // đồ thị có chu trình nên chúng ta dùng thuât toán kanh để kiểm tra xem có chu trình hay không

    public boolean Kanh() {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        // Thêm các đỉnh có độ vào bằng 0 vào hàng đợi
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Duyệt đồ thị bằng thuật toán Kahn
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            List<Integer> adjList = hashMap.get(node);

            if (adjList != null) {
                for (int neighbor : adjList) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        if(count == n) {
            return false;
        } else {
            return true;
        }

        // Đồ thị là DAG nếu tất cả các đỉnh đều được duyệt
    }

    public void check() {
        List<Integer> list2 = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (color[i] ==0) {
        // Do thuật toán Kanh tự duyệt các đỉnh nên không cần vòng lặp để duyệt nữa
                if (Kanh()) {
                    System.out.println("Yes");
                    return;
//                    list2.add(start);
//                    while (end != start) {
//                        list2.add(end);
//                        end = parent[end];
//                    }
//                    list2.add(start);
//                    Collections.reverse(list2);
//                    for (int j = 0; j < list2.size(); j++) {
//                        System.out.print(list2.get(j) + " ");
//                    }
//                    System.out.println();
                }

          //  }
        //}
        System.out.println("No");
        return;

    }


    public static void main(String[] args) {
        checkChuTrinh checkChuTrinh = new checkChuTrinh();
        checkChuTrinh.input();
        // đồ thị liên thông nên chỉ cần gọi từ 1 là nó sẽ chạy hết
        //chu trình còn nếu không liên thông thì ta phải duyệt hết các đỉnh cảu đồ thị
//        if(checkChuTrinh.Dfs(1,0)) {
//            System.out.println("Yes");
//        } else {
//            System.out.println("No");
//        }
      checkChuTrinh.check();
    }
}
