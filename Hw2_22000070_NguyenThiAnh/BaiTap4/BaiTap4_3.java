package Hw2_22000070_NguyenThiAnh.BaiTap4;
// De bai: Cho một dãy a gồm n số tự nhiên. Hãy đưa ra số tự nhiên nhỏ nhất chưa xuất hiện trong dãy.
public class BaiTap4_3 {
    public static int[] quickSort(int a[], int l, int r) {
        int p = a[(l+r)/2];
        int i = l, j = r;
        while (i < j){
            while (a[i] < p){
                i++;
            }
            while (a[j] > p){
                j--;
            }
            if (i <= j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (i < r){
            quickSort(a, i, r);
        }
        if (l < j) {
            quickSort(a, l, j);
        }
        return a;
    }

    public static int findNum(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if(a[i+1] != a[i] +1 ) {
                return a[i] + 1;
            }
        }
        return a[n - 1] + 1;
    }

    public static void main(String[] args) {
        int []a = {0,3,4,1,2,9,5};
        int numberMin = findNum(quickSort(a,0,a.length - 1));
        System.out.println("So tu nhien nho nhat chua xuat hien la: " + numberMin);

    }
}
