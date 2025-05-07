package LeetCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Đề bài
//Cho đồ thị có hướng G=<V,E> được biểu diễn dưới dạng danh sách cạnh. Hãy viết chương trình liệt kê các thành phần liên thông của đồ thị.
//Input
//Dòng đầu tiên chứa 2 số n, m là số đỉnh và số cạnh của đồ thị (1 <= n <= 1000, 1 <= m <= n*(n-1)/2).
//M dòng tiếp theo, mỗi dòng là 2 số u, v biểu diễn cạnh u, v của đồ thị (1 <= u, v <= n). Các cạnh được liệt kê theo thứ tự tăng dần của các đỉnh đầu.
//Output
//Ghi ra file văn bản lab_4_output.OUT gồm nhiều dòng, mỗi dòng liệt kê các đỉnh thuộc một thành phần liên thông.
public class lienthong {
    private HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visted = new boolean[1000];
    private   int n;
    public void readFile() {

            Scanner sc = new Scanner(System.in);
          n = sc.nextInt();
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
            }
    }

    public void setVisted() {
        for (int i = 0; i < visted.length; i++) {
            visted[i] = false;
        }
    }

    public void Dfs(int u ) {
        visted[u] = true;
        System.out.print(u + " ");
        List<Integer> list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if(!visted[b]) {
                    Dfs(b);
                }
            }
        }
    }

    public void check() {
        for (int i = 1; i <= n; i++) {
            if (!visted[i]) {
                Dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        lienthong lienthong = new lienthong();
        lienthong.readFile();
        lienthong.check();
    }
}
