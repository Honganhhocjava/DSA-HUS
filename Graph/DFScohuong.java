package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DFScohuong {

    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

    private boolean[] visted = new boolean[1000];
    public void readFile(String file) {
        //Chuyen tu danh sach ke sang ma tran ke
        try{
            Scanner sc = new Scanner(new FileReader(file));
            int n = sc.nextInt(); // so dinh
            int m = sc.nextInt(); // so canh
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
        } catch (FileNotFoundException e) {
            System.out.println();
        }
    }

    public void setVisted(){
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }


    public void DFS(int u) {
        readFile("dfscohuong.txt");
        System.out.print(u + " ");
        visted[u] =  true;
        List<Integer> list = new ArrayList<>();
        list = hashMap.get(u);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if (!visted[b]) {
                    DFS(b);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFScohuong dfScohuong = new DFScohuong();
        dfScohuong.DFS(1);
    }
}
