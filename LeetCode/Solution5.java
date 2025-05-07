package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Solution5 {
   //Tìm số tỉnh trong thành phố
    // Bài toán được mô tả như sau : các thành phố được biểu diễn trên 1 matrix n*n
    // nếu ti  ij = 1 thì giữa các tp có đường đi còn ij = 0 thì k có đường đi. vậy nên hẫy tìm có bao nhiêu tỉnh(bao gồm các tp có đường đi)
    //quy bài toán này về toán tìm số chu trình của 1 matrix


    private int n ;
    private boolean[][] visted;
    private int[][] matrix;
    private int[] dx= {0,0,-1,1};
    private int[] dy = {-1,1,0,0};
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        visted = new boolean[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }
    }

    public void Dfs(int u , int v) {
        visted[u][v] = true;
        for (int i = 0; i < 4; i++) {
            int x1=u +dx[i];
            int y1= v+ dy[i];

            if(x1>= 0 && x1<n && y1>=0 && y1<n &&  matrix[x1][y1]==1 && !visted[x1][y1]) {
                Dfs(x1,y1);
            }
        }
    }


    public int countProvince() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] ==1 && !visted[i][j]) {
                    Dfs(i,j);
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        solution5.input();
        System.out.println(solution5.countProvince());
    }


}
