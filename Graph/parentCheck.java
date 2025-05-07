package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

//Tìm đường đi giữa 2 đỉnh trên đồ thị
public class parentCheck {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visted;
    private int[] parent ;
    public void readFile(String file) {
        try{
            Scanner sc = new Scanner(new FileReader(file));
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            parent = new int[n +1];
            visted = new boolean[n+1];

            for (int i = 0; i < m; i++) {
                int v = sc.nextInt();
                int s = sc.nextInt();
                //nếu đây là đồ thị có hướng thì chỉ cần bỏ cái ngược lại.
                if(!hashMap.containsKey(v)) {
                    hashMap.put(v,new ArrayList<>());
                }
                hashMap.get(v).add(s);
//                if(!hashMap.containsKey(s)) {
//                    hashMap.put(s,new ArrayList<>());
//                }
//                hashMap.get(s).add(v);

            }

            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println();
        }
    }

    public void setVisted() {
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }

    public void setParent() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = 0;
        }
    }

    public void dfs(int u) {
        visted[u] = true;
        List<Integer> list = new ArrayList<>();
        list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int s = list.get(i);
                if (!visted[s]) {
                    // ghi nhận cha của s là u
                    parent[s] = u;
                    dfs(s);
                }
            }
        }
    }

    //Cach 2 dùng thuật toán bfs sẽ cho số lượng cạnh nhỏ nhất

    public void bfs(int u ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visted[u] = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int v = queue.peek();
            queue.remove();
            list = hashMap.get(v);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (!visted[list.get(i)]) {
                        queue.add(list.get(i));
                        visted[list.get(i)] = true;
                        parent[list.get(i)] = v;
                    }
                }
            }
        }
    }

    public void  Path(int u , int v) {
        //Phương thức tìm đường di giữa u và v
        dfs(u);
        if(!visted[v]) {
            System.out.println("Không có đường đi");
        } else {
            //Nếu có đường đi thì chúng ta phải truy vết đường đi
            List<Integer> list = new ArrayList<>();//Danh sách này để lưu đường đi
            //Bắt đầu từ đỉnh kết thúc cho đến khi giống cái bắt đầu
            while (v!= u) {
                list.add(v);
                v = parent[v];
            }
            list.add(u);
            Collections.reverse(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    public static void main(String[] args) {
        parentCheck parentCheck = new parentCheck();
        parentCheck.readFile("parent.txt");
        parentCheck.Path(1,10);
    }
}
