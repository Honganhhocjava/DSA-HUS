package BaiTap;
import java.util.*;
public class CountThanhPhanLienThong {
    int[] dx = {-1, 0, 0, 1}; // Di chuyển theo hướng lên, trái, phải, xuống
    int[] dy = {0, -1, 1, 0};
    int n, m;
    boolean[] visted;
    public int numProvinces(ArrayList<ArrayList<Integer>> adj, int n) {
        int count=0;
        visted=new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visted[i]){
                dfs(i,adj);
                count++;
            }
        }
        return count;

    }

    public void setVisted(){
        Arrays.fill(visted,false);
    }

    public void dfs(int u,ArrayList<ArrayList<Integer>> adj) {
        visted[u] = true;
        ArrayList<Integer> list = adj.get(u);
        if(list!=null){
            for (int i = 0; i <list.size() ; i++) {
                int b = list.get(i);
                if(!visted[b]) {
                    dfs(b,adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        CountThanhPhanLienThong countThanhPhanLienThong = new CountThanhPhanLienThong();
        // Ma trận đầu vào
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(0)));
        //list.add(new ArrayList<>(Arrays.asList(0,2)));
        // list.add(new ArrayList<>(Arrays.asList(0,2)));
        System.out.println(countThanhPhanLienThong.numProvinces(list,2));
    }

}
