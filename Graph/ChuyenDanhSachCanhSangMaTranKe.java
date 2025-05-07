package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ChuyenDanhSachCanhSangMaTranKe {
    public void loadGraphFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new FileReader(fileName));
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();

            int[][] adjMatrix = new int[n][n];
            for (int i = 0; i < m; i++) {
                String[] a = sc.nextLine().split(" ");
                int u = Integer.parseInt(a[0]) - 1;
                int v = Integer.parseInt(a[1]) - 1;
                adjMatrix[u][v] =  adjMatrix[v][u]=1;
            }


            System.out.println("Ma trận kề của đồ thị:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy tệp!");
        }
    }

    public static void main(String[] args) {
        ChuyenDanhSachCanhSangMaTranKe chuyenDanhSachCanhSangMaTraKe = new ChuyenDanhSachCanhSangMaTranKe();
        chuyenDanhSachCanhSangMaTraKe.loadGraphFromFile("fl.txt");
    }
}
