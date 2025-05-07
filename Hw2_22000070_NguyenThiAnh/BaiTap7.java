package Hw2_22000070_NguyenThiAnh;

import java.util.Random;


public class BaiTap7 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(100000) + 1;
        int x = random.nextInt(1000000) + 1;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =  random.nextInt(1000000) + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("So luong cap co tong bang " + x + " la: " + couple(arr,x));
    }
     public static int couple(int a[],int x) {
        int n = a.length;
        int count = 0;
         for (int i = 0; i < n - 1; i++) {
             for (int j = i+1; j < n ; j++) {
                if(a[i] + a[j] == x){
                    count++;
                }
             }
         }
         return count;
    }
}
