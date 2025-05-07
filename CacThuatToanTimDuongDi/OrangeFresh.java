package BaiTap;

import java.util.LinkedList;
import java.util.Queue;

public class OrangeFresh {
    class Vitri {
        int x, y;

        public Vitri(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] mat) {
        Queue<Vitri> queue = new LinkedList<>();
        int freshOranges = 0;

        // Khởi tạo hàng đợi với các cam thối ban đầu và đếm số lượng cam tươi
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new Vitri(i, j));
                } else if (mat[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // Nếu không có cam tươi, trả về 0
        if (freshOranges == 0) {
            return 0;
        }

        int[] dx = {-1, 0, 0, 1}; // Di chuyển theo hướng lên, trái, phải, xuống
        int[] dy = {0, -1, 1, 0};
        int time = 0; // Thời gian tối thiểu

        // Sử dụng BFS để lan truyền trạng thái thối
        while (!queue.isEmpty()) {
            int size = queue.size();
          //  boolean foundFresh = false; // Kiểm tra xem có cam tươi nào bị thối hay không trong vòng lặp này

            for (int i = 0; i < size; i++) {
                Vitri vitri = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x1 = vitri.x + dx[j];
                    int y1 = vitri.y + dy[j];

                    if (x1 >= 0 && x1 < mat.length && y1 >= 0 && y1 < mat[0].length && mat[x1][y1] == 1) {
                        mat[x1][y1] = 2;
                        queue.add(new Vitri(x1, y1));
                        freshOranges--;
                      //  foundFresh = true;
                    }
                }
            }

           // if (foundFresh) {
                time++;
            //}
            if(freshOranges==0){
                return time;
            } else if(freshOranges > 1) {
                return -1;
            }

        }
        return -1;

        // Kiểm tra xem còn quả cam tươi nào không
     //   return freshOranges == 0 ? time : -1;
    }

    public static void main(String[] args) {
        OrangeFresh orangeFresh = new OrangeFresh();
        int[][] grid = { {0, 1, 2}, {0, 1, 2}, {2, 1, 1} };
        System.out.println(orangeFresh.orangesRotting(grid));
    }
}
