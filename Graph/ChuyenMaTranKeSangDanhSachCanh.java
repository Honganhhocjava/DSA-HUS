package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ChuyenMaTranKeSangDanhSachCanh {
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
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == 1) {
                        System.out.println(v[i] + " " + v[j]);
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {
        ChuyenMaTranKeSangDanhSachCanh chuyenMaTranKeSangDanhSachCanh = new ChuyenMaTranKeSangDanhSachCanh();
        chuyenMaTranKeSangDanhSachCanh.loadGraphFromFile("file.txt");
    }
}
