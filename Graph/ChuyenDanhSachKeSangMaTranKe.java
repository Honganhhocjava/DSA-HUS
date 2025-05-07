package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ChuyenDanhSachKeSangMaTranKe {
    public void loadGraphFromFile(String fileName) {
        try{
            Scanner sc = new Scanner(new FileReader(fileName));
            int n= sc.nextInt();
            sc.nextLine();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n ; i++) {
                String[] a = sc.nextLine().trim().split(" ");
                for (int j = 0; j < a.length; j++) {
                    int k = Integer.parseInt(a[j]) - 1;
                    matrix[i][k] = 1;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();

            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ChuyenDanhSachKeSangMaTranKe chuyenDanhSachKeSangMaTranKe = new ChuyenDanhSachKeSangMaTranKe();
        chuyenDanhSachKeSangMaTranKe.loadGraphFromFile("dsk.txt");
    }
}
