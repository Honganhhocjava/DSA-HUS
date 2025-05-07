package reviewMidterm.HashMap;

import java.util.HashMap;

public class CountMinValue {
    public static long getMinValue(int[] v) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum +=v[i];
            if(hashMap.containsKey(v[i])) {
                hashMap.put(v[i] , hashMap.get(v[i]) +1);
            } else {
                hashMap.put(v[i],1);
            }
        }
        long min = sum - (v[0] * hashMap.get(v[0]));
        for (int j = 1; j < hashMap.size(); j++) {
            if((sum-(v[j])*hashMap.get(v[j])) < min) {
                min = sum-(v[j])*hashMap.get(v[j]);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] v = {6, 5, 2, 1, 2, 1, 1, 2, 2};
        System.out.println(getMinValue(v));

    }
}
