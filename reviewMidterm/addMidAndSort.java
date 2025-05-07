package reviewMidterm;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class addMidAndSort {
    public static int[] sort(int[] a, int k ) {
        int []b = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        b[a.length] = k;
        Arrays.sort(b);
        return b;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int k = 3;
        int []b = sort(a,k);
        for (int i = 0; i < b.length-1; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.print(b[b.length-1]);
    }

}
