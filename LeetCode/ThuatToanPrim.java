package LeetCode;

import Graph.Prim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ThuatToanPrim {
    // input
//6 9
//1 2 12
//1 3 4
//2 3 1
//2 4 5
//2 5 3
//3 5 2
//4 5 3
//4 6 10
//5 6 8

    class Node {// cái này là lưu 1 đỉnh và 1 trọng số
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    // nếu chúng ta muốn in ra cạnh và trọng số của cây khung nhoe nhất thì chúng ta sẽ tạo thêm class để chứa 1 cạnh nhé
    class Canh {
        int a, b, c;// dỉnh 1 đỉnh 2 và trọng số

        public Canh(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


    // Thuật toán prim dùng tốt nhất khi là danh sách kề ên sẽ phải dựng 1 danh sách kề
    private int n, m; // số đỉnh và số cạnh của đồ thị
    private HashMap<Integer, List<Node>> hashMap = new HashMap<>();
    private int[] used;
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        used = new int[n+1];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String a[] = sc.nextLine().trim().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            int z = Integer.parseInt(a[2]);
            if(!hashMap.containsKey(x)) {
                hashMap.put(x,new ArrayList<>());
            } hashMap.get(x).add(new Node(y,z));
            if(!hashMap.containsKey(y)) {
                hashMap.put(y,new ArrayList<>());
            } hashMap.get(y).add(new Node(x,z));
        }
    }

    public void setUsed() {
        for (int i = 0; i < used.length; i++) {
            used[i] = 0;
        }
    }
    public void Prim(int u) {
        List<Canh> result = new ArrayList<>();
        int d = 0;
        used[u] = 1;
        while (result.size() < (n-1)) {
            int x1 = -1;// đỉnh của cạnh
            int y1= -1;// đinht của cạnh
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if( used[i] == 1) {
                    // nếu đỉnh thứ i đã nằm trong cây khung thì ta phải duyệt các
                    // đỉnh kề của i và tìm ra cạnh kề có trọng số nhỏ nhất
                    List<Node> nodeList = hashMap.get(i);
                    if (nodeList != null) {// danh sách các đỉnh kề với đỉnh i
                        for (int j = 0; j < nodeList.size(); j++) {
                            Node node = nodeList.get(j);
                            int dinh = node.v;
                            int trongso = node.w;
                            if (used[dinh] == 0 && trongso < min) {
                                min = trongso;
                                x1 = dinh;
                                y1 = i;
                            }
                        }
                    }
                }
            }
            result.add(new Canh(y1,x1,min));
            d+=min;
            used[x1] =1;
        }
        System.out.println(d);
        for (int i = 0; i < result.size(); i++) {
            Canh canh =result.get(i);
            System.out.println(canh.a + " " +  canh.b + " " + canh.c);
        }

    }

    public static void main(String[] args) {
        ThuatToanPrim thuatToanPrim = new ThuatToanPrim();
        thuatToanPrim.input();
        thuatToanPrim.Prim(1);
    }
}
// kết quả
//18
//1 3 4
//3 2 1
//3 5 2
//5 4 3
//5 6 8