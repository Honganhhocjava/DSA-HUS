package Hw6_22000070_NguyenThiAnh.BaiTap4;

import java.util.HashMap;

//Cho hai mảng arr1 và arr2 có kích thước bằng nhau, nhiệm vụ là tìm xem hai mảng đã cho có bằng nhau hay không.
// Hai mảng được coi là bằng nhau nếu cả hai đều chứa cùng một tập hợp các phần tử, mặc dù cách sắp xếp (hoặc hoán vị)
// của các phần tử có thể khác nhau. Lưu ý: Nếu có sự lặp lại, thì số lượng các phần tử lặp lại cũng phải giống nhau
// để hai mảng được coi là bằng nhau.
public class CheckEquals {
    public static boolean check(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hashMap1 = new HashMap<>();
        HashMap<Integer,Integer> hashMap2 = new HashMap<>();
        if(arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (hashMap1.containsKey(arr1[i])) {
                hashMap1.put(arr1[i], hashMap1.get(arr1[i]) + 1);
            } else {
                hashMap1.put(arr1[i], 1);
            }
        }
            for (int i = 0; i < arr2.length; i++) {
                if(hashMap2.containsKey(arr2[i])) {
                    hashMap2.put(arr2[i],hashMap2.get(arr2[i]) +1) ;
                } else {
                    hashMap2.put(arr2[i] , 1);
                }
        }
        return hashMap1.equals(hashMap2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 4, 2, 1};
        System.out.println(check(arr1, arr2)); // true

        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {1, 2, 2, 4};
        System.out.println(check(arr3, arr4)); // false
    }
}
