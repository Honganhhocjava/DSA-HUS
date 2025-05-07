package Hw6_22000070_NguyenThiAnh.BaiTap4;


import java.util.HashMap;

//Cho một mảng arr[], tìm phần tử lặp lại đầu tiên. Phần tử này phải xuất hiện nhiều hơn một lần và chỉ số
// của lần xuất hiện đầu tiên của nó phải là nhỏ nhất.
// Lưu ý: Vị trí bạn trả về phải theo chỉ số bắt đầu từ 1.
public class FirstRepeated {
    public static int firstRepeated(int[] a) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(hashMap.containsKey(a[i])) {
                return hashMap.get(a[i]) + 1;
            } else {
                hashMap.put(a[i],i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a= {1, 5, 3, 4, 5, 5, 6};
        System.out.println(firstRepeated(a));
    }
}
