package reviewMidterm.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class TwoSum {
    //Cho một mảng số nguyên và một giá trị đích, hãy tìm hai số trong
    //mảng sao cho tổng của chúng bằng giá trị đích. Trả về chỉ số của hai số đó.
    public static int[] twoSum(int[] nums , int targets) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num2 = targets - nums[i] ;
            if(hashMap.containsKey(num2)) {
                return new int[] {hashMap.get(num2),i};
            } else {
                hashMap.put(nums[i],i);
            }

        }
        throw new NoSuchElementException();

    }

    public static void main(String[] args) {
        int[] nums= {2,1,3,5,6,7};
        int target = 6;
        int []b = twoSum(nums,target);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
