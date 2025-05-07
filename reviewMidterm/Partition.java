package reviewMidterm;

import java.util.Arrays;

public class Partition {
    public static int partition(int[] a) {
        Arrays.sort(a);
        double sum=0;
        double key = 0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        System.out.println(sum);
        System.out.println(a.length);
        key = sum / a.length;
        System.out.println(key);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] +" ");
        }
        int index = -1 ;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < key) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        int[] a = {1,2,3,5,4,1,3,4,5,6,10};
        int key = p.partition(a);
        System.out.println("key = " + a[key] + "index " + key);

    }
}
