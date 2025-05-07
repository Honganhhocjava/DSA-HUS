package Graph;

import java.util.*;


// đầu vào
//6 5
//2 1
//2 3
//3 4
//5 4
//1 6
public class Dothi2p {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private int[] color;
    int n;

    // Đọc đầu vào
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // Số lượng đỉnh
        int m = sc.nextInt();  // Số lượng cạnh
        color = new int[n + 1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
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

    public void setColor(){
        for (int i = 0; i < color.length; i++) {
            color[i] =-1;
        }
    }


    // cach check đồ thị có phải đồ thị 2 phía hay không

    public boolean Bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        color[u] = 0;// 0 là màu đỏ và 1 là màu xanh
        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<Integer> list = hashMap.get(v);
            if(list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    int b = list.get(i) ;
                        if(color[b] == -1) {
                            color[b] = 1 - color[v] ;
                            queue.add(b);
                    }
                        else if(color[b] == color[v]) {
                            return false;
                        }
                }
            }
        }
        return true;
    }

    // Do bài toán không nói là đồ thị chỉ có 1 thành phần liên thoog nên
    // chúng ta cần phải xét từ đỉnh 1 đến đỉnh n dể không bỏ xót trừng hợp nào

    public void dothi() {
        boolean check = true;
        for (int i = 1; i <= n; i++) {
            if(color[i] ==-1) {
                if(!Bfs(i)) {
                    check =false;
                    break;
                }
            }
        }
        if(check) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void main(String[] args) {
        Dothi2p dothi2p = new Dothi2p();
        dothi2p.input();
        dothi2p.dothi();
    }
}
