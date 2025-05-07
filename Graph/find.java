package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// bài toán tìm đường đi giữa 2 điểm trên 1 lưới
public class find {

    char a[][] = new char[1001][1001];
    int n ,m;
    boolean[][]  visted;
    private int x1,y1,x2,y2;
    int[] dx = {-1, 0, 0, 1}; // Di chuyển theo hướng lên, trái, phải, xuống
    int[] dy = {0, -1, 1, 0}; // Di chuyển theo hướng lên, trái, phải, xuống

    public void readFile(String file) {
        try{
            Scanner sc = new Scanner(new FileReader(file));
            n = sc.nextInt();
            m = sc.nextInt();
            visted = new boolean[n][m]; // Khởi tạo mảng visited
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String c = sc.nextLine().trim();
                for (int j = 0; j < m; j++) {
                    a[i][j] = c.charAt(j);
                    if(a[i][j] == 'A') {
                        x1=i;
                        y1=j;
                    } else if (a[i][j] == 'B') {
                        x2 = i;
                        y2=j;
                    }
                }
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println();
        }
    }

    public boolean dfs(int i , int j) {
        System.out.println(i+" "+ j);
        if(i ==x2 && j == y2){
            return true;
        }
        visted[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int i1 = i + dx[k];
            int j1 = j + dy[k];
            if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < m  && !visted[i1][j1] && a[i1][j1] !='x') {

              if( dfs(i1,j1) ) {
                  return true;
              }
            }
        }
        return false;

    }


    public void find() {
        if(dfs(x1,y1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        find fin = new find();
        fin.readFile("find.txt");
        fin.find();

    }
}
