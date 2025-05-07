package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BFS {
    private HashMap<Integer,List<Integer>>  hashMap = new HashMap<>();
    private boolean[] visted = new boolean[1000];

    public void readFile(String file) {
        try{
            Scanner sc = new Scanner(new FileReader(file));
            int n = sc.nextInt();//so dinh
            int m = sc.nextInt(); // so canh
            sc.nextLine();

            //chuyen tu danh sach canh sang danh sach ke
            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().trim().split(" ");
                int v = Integer.parseInt(a[0]);
                int s = Integer.parseInt(a[1]);

                if(!hashMap.containsKey(v)) {
                    hashMap.put(v,new ArrayList<>());
                }
                hashMap.get(v).add(s);

                if(!hashMap.containsKey(s)) {
                    hashMap.put(s,new ArrayList<>());
                }
                hashMap.get(s).add(v);

            }

            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println();
        }
    }


    public void isVisted() {
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }

    public void BFS(int u) {
        readFile("bfs.txt");
        // Tao ra 1 queue rỗng
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visted[u] = true;
        //buoc lap cho den khi hàng đợi rỗng
        while (!queue.isEmpty()) {
            int v = queue.peek();
            System.out.print(v + " ");
            queue.remove();
            List<Integer> list = new ArrayList<>();
            list = hashMap.get(v);
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if(!visted[b]) {
                    queue.add(b);
                    visted[b] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.BFS(1);
    }
}
