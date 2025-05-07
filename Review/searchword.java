package Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class searchword {
    int[] dx = {-1, 0, 0, 1}; // Di chuyển theo hướng lên, trái, phải, xuống
    int[] dy = {0, -1, 1, 0};
    int n, m;
    List<int[]> positions = new ArrayList<>();
    private boolean[][] visisted;

    public boolean isWordExist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        visisted = new boolean[n][m];

        // Tìm tất cả các vị trí của các ký tự trong từ
        for (int k = 0; k < word.length(); k++) {
            char c = word.charAt(k);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == c) {
                        positions.add(new int[]{i, j});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void setVisisted(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                visisted[i][j] = false;
            }
        }
    }
    public boolean dfs(char[][] board,String word , int x , int y , int index) {
        if (index == word.length()){
            return true;
        }

        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != word.charAt(index) || visisted[x][y]) {
            return false;
        }

        visisted[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1= y+dy[i];
             dfs(board,word,x1,y1,index+1);
            return true;
        }
        visisted[x][y] = false;
        return false;

    }

    public static void main(String[] args) {
        searchword searchword = new searchword();
        char[][] board = { {'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'} };
        String word =  "sa";
        System.out.println(searchword.isWordExist(board,word));
    }
}
