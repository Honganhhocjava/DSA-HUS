package Hw2_22000070_NguyenThiAnh.BaiTap4;

import java.util.Scanner;

// De bai : Nhập và một số nguyên dương n, tiếp theo là n số nguyên của dãy số a.
//Hãy in ra các số chính phương*  có trong dãy theo thứ tự tăng dần (phía sau mỗi phần tử có đúng một khoảng trắng),
// nếu không tồn tại số chính phương nào trong dãy a thì in ra "NULL".
//*Số chính phương là số có thể biểu diễn được dưới dạng bình phương của một số nguyên ví dụ 0, 1, 4, 9, 16, ...
// là các số chính phương.
public class BaiTap4_4 {
    public static boolean check(int n) {
        int k = (int) Math.sqrt(n);
        return k * k == n;
    }
    public static int[] checkNumber(int a[]) {
        int b[] = new int[a.length];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if(check(a[i])) {
               b[count] = a[i] ;
               count++;
            }
        }
        if (count == 0) {
            return null; // Trả về null nếu không tìm thấy số chính phương nào
        }
        int[] result = new int[count];
        System.arraycopy(b, 0, result, 0, count); // Điều chỉnh kích thước mảng để loại bỏ các số 0 thừa
        return result;
    }


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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.print("Nhap cac gia tri cua mang: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int c[] = checkNumber(a);
        quickSort(c,0,c.length - 1);
        System.out.print("Cac so chinh phuong la: ");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }

}
