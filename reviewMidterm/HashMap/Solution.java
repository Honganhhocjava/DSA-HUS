package reviewMidterm.HashMap;

import java.util.HashMap;
public class Solution {
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i) , hashMap.get(s.charAt(i)) +1);
            } else {
                hashMap.put(s.charAt(i) ,1) ;
            }
        }
        for (int i = 0; i <hashMap.size() ; i++) {
            if(hashMap.get(s.charAt(i)) ==1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
