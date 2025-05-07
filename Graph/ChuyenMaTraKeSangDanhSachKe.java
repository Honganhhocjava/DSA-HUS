package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.Scanner;

public class ChuyenMaTraKeSangDanhSachKe {
    public void loadGraphFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new FileReader(fileName));
            int n = sc.nextInt();
            sc.nextLine();
            String[] v = new String[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextLine().trim();
            }
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String a = sc.nextLine().trim();
                String[] temp = a.split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(temp[j]);
                }
            }

            HashMap<String, List<String>> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!hashMap.containsKey(v[i])) {
                    hashMap.put(v[i], new ArrayList<>());
                }
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != 0) {
                        hashMap.get(v[i]).add(v[j]);
                    }
                }
            }
            Set<String> keys = hashMap.keySet();
            for (String key : keys) {
                System.out.print(key + ": ");
                System.out.println(hashMap.get(key));
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ChuyenMaTraKeSangDanhSachKe chuyenMaTraKeSangDanhSachKe = new ChuyenMaTraKeSangDanhSachKe();
        chuyenMaTraKeSangDanhSachKe.loadGraphFromFile("file.txt");
    }
}
