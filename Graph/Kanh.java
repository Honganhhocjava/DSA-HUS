package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Kanh {
    //tìm topo của đồ thị bằng thuật toasn kanh chỉ dùng cho đồ thị có hướng
    // tìm các bán bậc vào của các đỉnh, nếu bán bậc vào bằng 0 sẽ xuát hiện đầu tiên trong topo

    private final HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    private boolean[] visited;
    private List<Integer> integerList = new ArrayList<>();
    private int n;
    private int[] inDegree;

    public void readFile(String file) {
        try (Scanner sc = new Scanner(new FileReader(file))) {
            n = sc.nextInt();
            int m = sc.nextInt();
            visited = new boolean[n + 1];
            inDegree = new int[n+1];
            sc.nextLine();

            for (int i = 0; i < m; i++) {
                String[] edge = sc.nextLine().trim().split(" ");
                int v = Integer.parseInt(edge[0]);
                int s = Integer.parseInt(edge[1]);
                if(!hashMap.containsKey(v)) {
                    hashMap.put(v,new ArrayList<>());
                }
                hashMap.get(v).add(s);
                inDegree[s]++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }
    }

    public void Kanh(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(inDegree[i] == 0 ) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            integerList.add(u);
            List<Integer> list = hashMap.get(u);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    int b = list.get(i);
                    inDegree[b]--;
                    if (inDegree[b] == 0) {
                        queue.add(b);
                    }
                }
            }
        }
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) +" ");
        }
    }

    public static void main(String[] args) {
        Kanh kanh = new Kanh();
        kanh.readFile("topo.txt");
        kanh.Kanh();
    }

}
