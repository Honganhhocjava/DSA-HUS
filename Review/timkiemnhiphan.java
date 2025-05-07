package Review;

public class timkiemnhiphan {
    public static int max(double[] a, int n) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high){
            int mid = (high+low)/2;
            if(a[mid] < a[mid+1]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
