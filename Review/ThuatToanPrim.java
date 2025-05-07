package Review;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Đầu vào
//6 8
//1 2 9
//1 3 4
//2 3 1
//2 4 6
//3 5 2
//4 5 3
//4 8 10
//5 6 8
public class ThuatToanPrim {
    class  Canh{
        int a ,b,c;
        public Canh(int a, int b , int c) {
            this.a = a; this.b=b;this.c=c;
        }
    }
    class Node{
        int u ;// đỉnh
        int v;// trọng số
        public Node(int u , int v ) {
            this.u = u;
            this.v= v;

        }
    }
    private int n,m ;
    private List<Canh> list = new ArrayList<>();// tạo list để lưu danh sách cạnh
    private HashMap<Integer,List<Node>>  hashMap = new HashMap<>();
    private boolean[] used;// used == true thì used thuoocj cây khung và used == false thì thuộc đồ thị banđàu
    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        used = new boolean[1000];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] a = sc.nextLine().trim().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            int z = Integer.parseInt(a[2]);
            if(!hashMap.containsKey(x)) {
                hashMap.put(x, new ArrayList<>());
            } hashMap.get(x).add(new Node(y,z));
            if(!hashMap.containsKey(y)) {
                hashMap.put(y, new ArrayList<>());
            } hashMap.get(y).add(new Node(x,z));
        }
    }

    public void setUsed() {
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
    }

    public void Prim(int u) {
        //tạo 1 cây khung rỗng và 1 biến chiều dài cây = 0;
        List<Canh> MST = new ArrayList<>();
        int d =0;
        used[u]  = true;// đưa đỉnh u vào trong MST
        while (MST.size() < n-1) {
            // chọn ra cạnh e ngắn nhất có 1 đỉnh thuộc đồ thị và 1 đỉnh thuộc MST
            int x1 = 0 ;
            int y1=0; // lưu 2 đỉnh của cạnh e
            int minW = Integer.MAX_VALUE;// lưu trọng ssoos nhỏ nhất
            for (int i = 1; i <=n ; i++) {
                if(used[i] == true) {
                    List<Node> list1 = hashMap.get(i);
                    // nếu i thuốc tập MST thì duyệt danh sach kề của i
                    if(list1!=null) {
                        for (int j = 0; j < list1.size(); j++) {
                            Node node = list1.get(j);
                            int canhke = node.u;
                            int trongso = node.v;
                            if(!used[canhke] && trongso < minW) {
                                minW = trongso;
                                x1= canhke;
                                y1= i;
                            }
                        }
                    }
                }
            }
            MST.add(new Canh(x1,y1,minW));
            d += minW;
            used[x1] = true;

        }
        System.out.println(d);
        for (int i = 0; i < MST.size(); i++) {
            Canh canh = MST.get(i);
            System.out.println(canh.a + " " +  canh.b + " " + canh.c);
        }
    }
    public static void main(String[] args) {
        ThuatToanPrim prim = new ThuatToanPrim();
        prim.input();
        prim.Prim(1);
    }

}
