package Hw3_22000070_NguyenThiAnh.BaiTap1;

public class main {
    public static void main(String[] args) {
        Fraction a[] = {
                new Fraction(3,2),
                new Fraction(3,2),
                new Fraction(3, 2),
                new Fraction(5, 3),
                new Fraction(7, 4),
                new Fraction(2, 5)
        };
        System.out.println( "phan so o vi tri thu 3 trong mang la: " + a[2].toString());
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println("Tổng: " + a[i].add(a[i + 1]).result());
            System.out.println("Hiệu: " + a[i].minus(a[i + 1]).result());
            System.out.println("Nhân: " + a[i].multi(a[i + 1]).result());
            System.out.println("Chia: " + a[i].divi(a[i + 1]).result());
        }
    }
}
