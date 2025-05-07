package BaiTap;

import java.util.*;

public class WordSearch {
    int[] dx = {-1, 0, 0, 1}; // Di chuyển theo hướng lên, trái, phải, xuống
    int[] dy = {0, -1, 1, 0};
    int n, m;
    List<int[]> positions = new ArrayList<>();

    public boolean isWordExist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        boolean[][] visited = new boolean[n][m];

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

        // Kiểm tra tất cả các vị trí của ký tự đầu tiên
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false; // Không tìm thấy từ trên bảng
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;

        // Di chuyển theo 4 hướng
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (dfs(board, visited, word, x1, y1, index + 1)) {
                return true;
            }
        }

        visited[x][y] = false; // Quay lui
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = { {'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'} };
        String word =  "sa"; System.out.println(wordSearch.isWordExist(board, word));
    }
}
