package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BFScohuong {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visted ;

    public void readFile(String file) {
        try{
            Scanner sc = new Scanner(new FileReader(file));
            int n = sc.nextInt();
            int m = sc.nextInt();
            visted = new boolean[n+1];
            sc.nextLine();
            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().trim().split(" ");
                int s = Integer.parseInt(a[0]);
                int v = Integer.parseInt(a[1]);
                if (!hashMap.containsKey(s)) {
                    hashMap.put(s, new ArrayList<>());
                }
                hashMap.get(s).add(v);
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

    public void BFS(int u) {
        readFile("bfscohuong.txt");
        //Tao ra 1 hàng đợi
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visted[u] = true;
        while (!queue.isEmpty()) {
            int v = queue.peek();
            System.out.print(v + " ");
            queue.remove();
            List<Integer> l = new ArrayList<>();
            l = hashMap.get(v);
            if(l!= null) {
                for (int i = 0; i < l.size(); i++) {
                    int b = l.get(i);
                    if (!visted[b]) {
                        queue.add(b);
                        visted[b] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BFScohuong bfScohuong = new BFScohuong();
        bfScohuong.BFS(1);
    }
}
