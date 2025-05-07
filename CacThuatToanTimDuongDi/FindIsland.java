package BaiTap;
import java.util.*;

public class FindIsland {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    int parent[] ;
    boolean [][]vissted;
    int[] dx = {-1,-1,-1,0,0,1,1,1};
    int[] dy ={0,-1,1,-1,1,-1,0,1};
    private int n , m;
    char[][] a ;

    public int numIslands(char[][] grid) {
        a =grid;
        n = grid.length;
        m = grid[0].length;
        vissted = new boolean[n +1][m+1];
        return path(0,0);

    }

    public void setV() {
        for (int i = 0; i < vissted.length; i++) {
            for (int j = 0; j < vissted[0].length; j++) {
                vissted[i][j] = false;
            }
        }
    }

    public void dfs(int x,int y) {
        vissted[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if(x1>=0 && x1<n && y1 >=0 && y1 <m &&!vissted[x1][y1] && a[x1][y1] =='1' ) {
                dfs(x1,y1);
            }
        }
    }
    public int  path(int x , int y){
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!vissted[i][j] && a[i][j] =='1') {
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindIsland findIsland = new FindIsland();
        //[0,1,1,1,0,0,0],[0,0,1,1,0,1,0
        char[][] a = {
                {'0','1','1','1','0','0','0'},
                {'0','0','1','1','0','1','0'}
        };
        System.out.println(findIsland.numIslands(a));
    }

}
