package Hw6_22000070_NguyenThiAnh.BaiTap1;

import java.util.HashMap;

public class Subarray {
    public  static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        hashMap.put(0,1);
        for (int num : nums) {
            sum+=num;
            if(hashMap.containsKey(sum-k)){
                count+= hashMap.get(sum-k);
            }
            if(!hashMap.containsKey(sum)) {
                hashMap.put(sum, 0);
            }
            hashMap.put(sum,hashMap.get(sum) +1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;
        System.out.println(subarraySum(nums,k));
    }
}
