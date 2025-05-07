package reviewMidterm.PriorityQueue;

public class heapHeight {
    static int heapHeight(int N, int arr[]){
        // code here
        int count = 0;
        int i = 0;
        while (i < N) {
            i = 2 * i + 1;
            count++;
        }

        return count - 1;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] arr = {1, 3, 6, 5, 9, 8};
        System.out.println(heapHeight(N,arr));
    }
}
