package reviewMidterm.HashMap;

import java.util.HashMap;

public class CountDistinct {
    public static void countDistinct(int[] arr, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if(hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i],hashMap.get(arr[i]) +1);
            } else {
                hashMap.put(arr[i],1);
            }
        }
        System.out.println(hashMap.size());
        for (int i = k; i < arr.length; i++) {
            if(hashMap.get(arr[i-k])==1) {
                hashMap.remove(arr[i-k]);
            } else {
               hashMap.put(arr[i-k], hashMap.get(arr[i-k])-1);
            }
            if(hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) +1);
            } else {
                hashMap.put(arr[i] ,1);
            }
            System.out.println(hashMap.size());
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int K = 4;
        countDistinct(arr, K);
    }
}
