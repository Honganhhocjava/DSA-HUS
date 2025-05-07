package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DFS {


    boolean[] visted = new boolean[1000];
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    // dau tien doc du lieu va chuyen sang danh sach ke
    public void loadFile(String file) {
        try {
            Scanner sc = new Scanner(new FileReader(file));
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().trim().split(" ");
                int s = Integer.parseInt(a[0]);
                int v = Integer.parseInt(a[1]);
                if (!hashMap.containsKey(s)) {
                    hashMap.put(s, new ArrayList<>());
                }
                hashMap.get(s).add(v);

                //Nếu đồ thị có hướng thì không cần phải thêm s vào trong v nữa

                if (!hashMap.containsKey(v)) {
                    hashMap.put(v, new ArrayList<>());
                }
                hashMap.get(v).add(s);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println();
        }
    }

    public void setVisted() {
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }

    public void DFS(int u) {
        loadFile("dfs.txt");
        System.out.print(u + " ");
        // danh dau u da duoc tham
        visted[u] = true;
        List<Integer> list = new ArrayList<>();
        list = hashMap.get(u);
        for (int i = 0; i < list.size(); i++) {
            int b = list.get(i);
            if (!visted[b]) {
                DFS(b);
            }

        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
       // dfs.loadFile("dfs.text");
        dfs.DFS(1);
    }
}
