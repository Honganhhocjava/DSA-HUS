package reviewMidterm.HashMap;

import java.util.HashMap;

public class SubArraySum {
    public static  int subArraySum(int[] nums , int key)   {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i] ;
            if(sum == key ) {
                count++;
            }
            if(hashMap.containsKey(sum-key)) {
                count += hashMap.get(sum-key);
            }
            if(hashMap.containsKey(sum) ){
                hashMap.put(sum, hashMap.get(sum) +1);
            }else {
                hashMap.put(sum,1);
            }

        }
        return count;

    }

    public static void main(String[] args) {
        int []nums = {1,1,1};int k = 2;
        System.out.println(subArraySum(nums,k));
    }
}
