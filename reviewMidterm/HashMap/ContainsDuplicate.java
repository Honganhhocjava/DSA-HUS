package reviewMidterm.HashMap;

import java.util.HashMap;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i] , hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i] , 1);
            }
        }
        for (int i = 0; i < hashMap.size(); i++) {
            if(hashMap.get(nums[i]) >1) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
