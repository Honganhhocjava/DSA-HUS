package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

// Bài tập đếm thành phần liên thông trên lưới
public class Count {
    int n; // số hàng
    int m; // số cột
    private int[][] a = new int[1001][1001]; // Mảng lưới
    int[] dx = {-1, 0, 0, 1}; // Di chuyển theo hướng lên, trái, phải, xuống
    int[] dy = {0, -1, 1, 0}; // Di chuyển theo hướng lên, trái, phải, xuống
    boolean[][] visited; // Mảng đánh dấu các ô đã thăm

    // Hàm đọc dữ liệu từ file
    public void readFile(String file) {
        try {
            Scanner sc = new Scanner(new FileReader(file));
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine(); // Đọc dòng trống còn lại
            visited = new boolean[n][m]; // Khởi tạo mảng visited
            for (int i = 0; i < n; i++) {
                String[] c = sc.nextLine().trim().split(" "); // Đọc dòng dữ liệu và phân tách theo khoảng trắng
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(c[j]); // Sửa thành c[j] để lấy đúng cột
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại!");
        }
    }

    // Hàm DFS để duyệt các ô liên thông
    public void dfs(int i, int j) {
        //System.out.println(i + " " + j);
        visited[i][j] = true; // Đánh dấu ô (i, j) đã thăm
        // Duyệt các đỉnh kề của ô (i, j)
        for (int k = 0; k < 4; k++) { // Vì mỗi ô chỉ kề với 4 ô
            int i1 = i + dx[k];
            int j1 = j + dy[k];

            // Kiểm tra giới hạn và nếu ô đó là 1 và chưa thăm
            if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < m && a[i1][j1] == 1 && !visited[i1][j1]) {
                dfs(i1, j1); // Gọi đệ quy với ô kề

            }

        }
    }

    public void bfs(int i , int j) {
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        // Thêm cặp (i, j) vào hàng đợi
        q.add(new AbstractMap.SimpleEntry<>(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Map.Entry<Integer, Integer> current = q.poll();
            int x = current.getKey();
            int y = current.getValue();

            // Duyệt các đỉnh kề
            for (int k = 0; k < 4; k++) {
                int i1 = x + dx[k];
                int j1 = y + dy[k];

                // Kiểm tra điều kiện biên và ô chưa thăm
                if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < m && a[i1][j1] == 1 && !visited[i1][j1]) {
                    visited[i1][j1] = true;
                    q.add(new AbstractMap.SimpleEntry<>(i1, j1)); // Thêm vào hàng đợi
                }
            }
        }

    }

    // Hàm đếm số thành phần liên thông
    public int count() {
        readFile("count.txt"); // Đọc dữ liệu từ file
        int count = 0; // Đếm số thành phần liên thông
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Nếu ô (i, j) là 1 và chưa thăm, thực hiện DFS
                if (a[i][j] == 1 && !visited[i][j]) {
                   // System.out.println("lthong thứ " + count+1);
                    bfs(i, j); // Duyệt DFS cho thành phần liên thông này
                    count++; // Tăng số thành phần liên thông
                }
            }
        }
        return count; // Trả về số thành phần liên thông
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        Count count = new Count();
        System.out.println("Tổng các thành phần liên thông: " + count.count()); // In ra số thành phần liên thông
    }
}
