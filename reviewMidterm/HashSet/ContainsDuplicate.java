package reviewMidterm.HashSet;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) {
                return true;
            }else {
                hashSet.add(nums[i]);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int []a = {1,2,3,4,1} ;
        int []b = {1,2,3,4} ;
        System.out.println(containsDuplicate(a));
        System.out.println(containsDuplicate(b));

    }
}
