package reviewMidterm;

public class Pattern {


    public static int match(int[] a, int[] b) {
        int count = 0;
        for (int i = 0; i <= b.length - a.length; i++) {
            boolean found = true;
            for (int j = 0; j < a.length; j++) {
                if (b[i + j] != a[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }
        return count > 0 ? count :  -1;

    }
    public static void main(String[] args) {
        int []a = {1,2,3,4};
        int []b = {1,2,3,1,2,3,4,5,1,2,3,4};
        System.out.println(match(a,b));
    }
}
