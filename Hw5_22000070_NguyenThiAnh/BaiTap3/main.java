package Hw5_22000070_NguyenThiAnh.BaiTap3;

public class main {
    public static void main(String[] args) {
        ControlSystem controlSystem = new ControlSystem();
        controlSystem.add("TL to Vn" , 2);
        controlSystem.add("TL to Korea" ,5);
        controlSystem.add("VN to Korea" ,10);
        controlSystem.add("India to Korea" ,4);
        controlSystem.add("TL to India" ,7);

        controlSystem.processNextEvent();

    }
}

