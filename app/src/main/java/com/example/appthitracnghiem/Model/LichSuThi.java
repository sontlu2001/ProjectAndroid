package com.example.appthitracnghiem.Model;

public class LichSuThi {
    private String tenDeThi;
    private String tenMonThi;
    private double diem;

    public LichSuThi() {
    }

    public LichSuThi(String tenDeThi, double diem, String tenMonThi) {
        this.tenDeThi = tenDeThi;
        this.tenMonThi = tenMonThi;
        this.diem = diem;
    }


    public String getTenMonThi() {
        return tenMonThi;
    }

    public void setTenMonThi(String tenMonThi) {
        this.tenMonThi = tenMonThi;
    }

    public String getTenDeThi() {
        return tenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
