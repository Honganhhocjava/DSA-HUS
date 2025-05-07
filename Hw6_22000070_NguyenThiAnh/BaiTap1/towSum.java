package Hw6_22000070_NguyenThiAnh.BaiTap1;

import java.util.HashMap;

public class towSum {
    public  static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int so = 0;
        for (int i = 0; i < nums.length; i++) {
            so = target-nums[i];
            if(hashMap.containsKey(so)) {
                return new int[]{hashMap.get(so),i};
            }
            hashMap.put(nums[i],i);

        }
        throw new IllegalStateException("No");
    }

    public static void main(String[] args) {
        int a[] ={1,2,3,4,1,2};
        int ta = 3;
        int[] b = twoSum(a,ta);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }
}
