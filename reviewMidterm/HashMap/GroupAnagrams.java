package reviewMidterm.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            if(!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
          }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String []str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(str);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i) + " ");
        }
    }
}
