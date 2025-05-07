package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ConectedComponed {
    //kiểm tra thành phần liên thông của đồ thị
    // kiểm tra bằng cách dùng bfs hoặc là dfs

    private HashMap<Integer, List<Integer>>  hashMap = new HashMap<>();
    private boolean[] visted = new boolean[1000];
    public void readFile(String file) {
        try{
            Scanner sc = new Scanner(new FileReader(file));
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();


            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().trim().split(" ");
                int v = Integer.parseInt(a[0]);
                int u = Integer.parseInt(a[1]);
                if(!hashMap.containsKey(v)) {
                    hashMap.put(v,new ArrayList<>());
                }
                hashMap.get(v).add(u);

                if(!hashMap.containsKey(u)) {
                    hashMap.put(u,new ArrayList<>());
                }
                hashMap.get(u).add(v);
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

    public void DFS(int u) {
        visted[u] = true;
        System.out.print(u + " ");
        List<Integer> list = new ArrayList<>();
        list = hashMap.get(u);
        if(list!= null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if (!visted[b]) {
                    DFS(b);
                }
            }
        }
    }

    public void conectComponed() {
        int count = 0 ;
        for (int i = 0; i < hashMap.size() ; i++) {
            if(!visted[i]){
                count+=1;
               System.out.print("các đinh thuộc thành phần liên thông thứ " + count + " là: ");
                DFS(i);
                System.out.println();
            }
            
        }
       System.out.println("So thanh phan lien thong cua do thi: " + count);// in ra so thanh phan lien thong
    }

    public static void main(String[] args) {
        ConectedComponed conectedComponed = new ConectedComponed();
        conectedComponed.readFile("conect.txt");
        conectedComponed.conectComponed();
    }
}
