package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;
import java.util.*;

public class ChuyenDanhSachCanhsangDanhSachKe {
    public void loadGraphFromFile(String fileName) {
        try{
            Scanner sc = new Scanner(new FileReader(fileName));
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            HashMap<String,List<String>> adjList = new HashMap<>();
            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().split(" ");
                String u = a[0];
                String v = a[1]; // Đỉnh v

                if (!adjList.containsKey(u)) {
                    adjList.put(u, new ArrayList<>());
                }
                adjList.get(u).add(v);

                if (!adjList.containsKey(v)) {
                    adjList.put(v, new ArrayList<>());
                }
                adjList.get(v).add(u);

            }

            Set<String> keys = adjList.keySet();
            for (String key : keys) {
                System.out.print(key + ": ");
                System.out.println(adjList.get(key));
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public static void main(String[] args) {
        ChuyenDanhSachCanhsangDanhSachKe chuyenDanhSachCanhsangDanhSachKe = new ChuyenDanhSachCanhsangDanhSachKe();
        chuyenDanhSachCanhsangDanhSachKe.loadGraphFromFile("fl.txt");
    }
}
