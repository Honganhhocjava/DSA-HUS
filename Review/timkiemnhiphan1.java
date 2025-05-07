package Review;


public class timkiemnhiphan1 {
    public static int max(double[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            int mid = (high + low) / 2;
            if (mid + 1 < a.length && a[mid] < a[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Trả về chỉ số của phần tử lớn nhất
    }

    public static void main(String[] args) {
        double[] a = {1.0, 2.0, 3.0, 5.0, 4.0, 2.0};
        int indexMax = max(a);
        System.out.println("Chỉ số của phần tử lớn nhất là: " + indexMax);
        System.out.println("Phần tử lớn nhất là: " + a[indexMax]);
    }
}

