package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Solution7 {
    private HashMap<Integer, List<Integer>>  hashMap = new HashMap<>();
    int count = 0;
    private int[] visited;
    public void input( List<List<Integer>> newL) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < newL.size(); i++) {
            hashMap.put(i,newL.get(i));
        }
        visited = new int[newL.size() +1];
        int size = Dfs(0);
        if(count == newL.size()) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
    }

    public void setVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
    }

    public int Dfs(int u) {
        visited[u] = 1;
        count++;
        List<Integer>  list = hashMap.get(u);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                int b = list.get(i);
                if (visited[b] == 0) {
                    Dfs(b);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<Integer>> newL = new ArrayList<>();
        newL.add(Arrays.asList(1));
        newL.add(Arrays.asList(2));
        newL.add(Arrays.asList(3));
        newL.add(Arrays.asList());
        Solution7 dinhtruvaCanhcau = new Solution7();
        dinhtruvaCanhcau.input(newL);


    }
}
