package reviewMidterm;

public class Robot {
    public static int countPath(int M, int N, int t) {
        return left(1, t, M, N) + right(1, t+1, M, N);
    }

    public static int left(int x, int y, int M, int N) {
        if (x == M && (y == 1 || y == N)) {
            return 1;
        }

        if (y < 1 || y > N || x > M) {
            return 0;
        }

        // Move left or down
        return left(x + 1, y, M, N) + left(x, y - 1, M, N);
    }

    public static int right(int x, int y, int M, int N) {
        if (x == M && (y == 1 || y == N)) {
            return 1;
        }

        if (y < 1 || y > N || x > M) {
            return 0;
        }

        // Move right or down
        return right(x + 1, y, M, N) + right(x, y + 1, M, N);
    }

    public static void main(String[] args) {
        int a = countPath(4, 4, 2);
        System.out.println(a);
    }
};

