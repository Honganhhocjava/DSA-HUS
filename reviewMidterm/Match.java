package reviewMidterm;

public class Match {
    public static int match(int[] a, int[] b) {
        int count = 0;
        for (int i = 0; i < b.length - a.length; i++) {
            boolean check = true;
            for (int j = 0; j < a.length; j++) {
                if(b[i+j] != a[j]) {
                    check = false;
                    break;
                }
            }
            if(check) {
              count++;
            }
        }
        return count > 0 ? count : -1;


    }


    public static void main(String[] args) {
        int []a = {1,2,3,4,5};
        int []b = {1,2,3,4,6,1,2,3,4,5,7,8,9,1,2,3,4,5,5,6,7,8};
        int c = match(a,b);
        System.out.println(c);
    }
}
