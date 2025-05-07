package reviewMidterm.HashMap;

import java.util.HashMap;

public class FirstRepeats {
    public static int firstRepeat(int[] array,int n) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) +1);
            } else {
                hashMap.put(array[i] , 1);
            }
        }
        for (int i = 0; i < hashMap.size(); i++) {
            if(hashMap.get(array[i]) > 1) {
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []arr = {6, 10, 5, 4, 9, 120, 4, 6, 10};
        int n = arr.length;
        System.out.println(firstRepeat(arr,n) + " la phan tu lap lai lan dau tien");
    }
}
