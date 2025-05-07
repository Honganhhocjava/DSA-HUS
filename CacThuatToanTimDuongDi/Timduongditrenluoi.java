package BaiTap;

import java.util.Arrays;
import java.util.Scanner;

// đầu vào
//6 6
//Aooxoo
//oxoooo
//oxoooo
//ooooxx
//Boooxo
//oooxxx
public class Timduongditrenluoi {
    private char[][] c;
    private int n,m;
    private boolean[][] visited;
    private int x1,y1,x2,y2;
    int[] dx = {-1, 0, 0, 1}; // Di chuyển theo hướng lên, trái, phải, xuống
    int[] dy = {0, -1, 1, 0}; // Di chuyển theo hướng lên, trái, phải, xuống
    int[][] pa;
    public void input() {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt();
        m = sc.nextInt();
        c = new char[n][m];
        pa = new int[n][m];
        sc.nextLine();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String a = sc.nextLine().trim();
            for (int j = 0; j < m; j++) {
                c[i][j] = a.charAt(j);
                if (c[i][j] == 'A') {
                    x1=i;
                    y1=j;
                } else if(c[i][j] == 'B') {
                    x2 = i;
                    y2=j;
                }

            }
        }
    }

    private void setVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;

            }

        }
    }

    public boolean Dfs(int x , int y) {
        if(x == x2 && y == y2) {
            return true;
        }
        visited[x][y] = true;
        System.out.println(x+ " " + y);
        for (int i = 0; i < 4; i++) {
            int x11 = x + dx[i];
            int y11 = y + dy[i];
            if(x11>=0 && x11 < n && y11 >=0 && y11 < m && !visited[x11][y11] && c[x11][y11] != 'x') {
               if( Dfs(x11,y11)) {
                   return true;
               }
            }
        }
        return false;
    }


    public void find () {
        if(Dfs(x1,y1)) {
            System.out.println("Có đường đi");
        } else {
            System.out.println("Không có đường di");
        }
    }

    public static void main(String[] args) {
        Timduongditrenluoi timduongditrenluoi = new Timduongditrenluoi();
        timduongditrenluoi.input();
        timduongditrenluoi.find();
    }
}
