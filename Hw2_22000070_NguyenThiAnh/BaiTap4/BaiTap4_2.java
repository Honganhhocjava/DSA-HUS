package Hw2_22000070_NguyenThiAnh.BaiTap4;
// De bai: Hải có một dãy số gồm n số nguyên, Hải muốn sắp xếp các phần tử của dãy đó với các yêu cầu sau:
//Từ trái qua phải:
//Các số nguyên dương xuất hiện theo giá trị tăng dần.
//Các số nguyên âm xuất hiện theo giá trị giảm dần.
//Không thay đổi vị trí của phần tử mang giá trị 0.
//Không thay đổi tính chất ở mỗi vị trí (Nghĩa là nếu trước khi sắp xếp vị trí i có giá trị nguyên âm
// thì sau khi sắp xếp vị trị i cũng phải mang giá trị âm, nếu ví trị i mang giá trị dương cũng tương tự).
public class BaiTap4_2 {
    public static int[] Sort(int a[]) {
        boolean swap = false;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if(a[i] == 0 ) {
                swap = true;
            }
            for (int j = i + 1; j < n ; j++) {
                if (a[j] < a[i] && a[j] > 0 && a[i] > 0) {
                    swap(a, i, j);
                } else if (a[j] < 0 && a[i] < 0 && a[j] > a[i]) {
                    swap(a, i, j);
                }
            }
        }
        return a;
    }
     public static void swap(int a[] , int i , int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
     }

    public static void main(String[] args) {
        int a[] = {3,-1,2,0,-4,6};
        //int a[] = {0,7,0,5};
        Sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
