package reviewMidterm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class count {
    public static void count(int[] a) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(hashMap.containsKey(a[i])) {
                hashMap.put(a[i] , hashMap.get(a[i]) + 1);
            } else {
                hashMap.put(a[i] , 1);
            }
        }

        for (int i = 0; i < hashMap.size(); i++) {
            int key = (int)  hashMap.get(a[i]);
            System.out.println(a[i] + " " + key);
        }

    }

    public static void main(String[] args) {
        int []a = {1,2,3,1,1,2,1};
        count(a);

    }
}
