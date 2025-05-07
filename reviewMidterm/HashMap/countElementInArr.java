package reviewMidterm.HashMap;

import java.util.HashMap;

public class countElementInArr {
    public static void count(String []nums) {
       // HashMap<Integer,Integer> hashMap = new HashMap<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
          for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i] ,1);
            }
        }

        for (int i = 0; i < hashMap.size(); i++) {
            String key = (String) hashMap.keySet().toArray()[i];
            System.out.println(key + " : " + hashMap.get(key));
        }
    }


    public static void main(String[] args) {
       // int []a = {1,1,1,2,3,4,1,3,4,4,3,6,0};
        String []a = {"A" ,"B" ,"Vc" ,"A"};
        count(a);
    }
}
