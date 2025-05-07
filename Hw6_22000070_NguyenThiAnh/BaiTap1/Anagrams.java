package Hw6_22000070_NguyenThiAnh.BaiTap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for (String st :strs) {
            char[] s = st.toCharArray();
            Arrays.sort(s);
            String a = new String(s);
            if(hashMap.containsKey(a)) {
                hashMap.get(a).add(st);
            } hashMap.put(a,new ArrayList<>());
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {

    }
}
