package Review;

import java.util.Scanner;

public class dondothidaydu {
    private int[][] a;
    private int n,m;
    public void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n +1][m+1];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String c[] = sc.nextLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(c[j]);
            }
        }
    //    System.out.println(checkDondothi());
    }

    public boolean checkDondothi(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==j && a[i][j] !=0 ){
                    return false;
                }
                else if(i!=j && a[i][j] !=1){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        dondothidaydu dondothidaydu = new dondothidaydu();
        dondothidaydu.input();
        System.out.println(dondothidaydu.checkDondothi());
    }
}
// dau vao
// 4 4
//0 1 1 1
//1 0 1 1
//1 1 0 1
//1 1 1 0