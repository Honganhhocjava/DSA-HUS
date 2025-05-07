package reviewMidterm;

public class TopK {
    public static int getTopK(int []a, int k) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    temp = a[j];
                }
            }
        }
        return a[k-1];

    }
    public static void main(String[] args) {
        int []a = {1,3,2,1,4,5,6,7};
        int k = 1;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +" ");
        }
        System.out.println();
        System.out.println(getTopK(a,k));
    }

}
