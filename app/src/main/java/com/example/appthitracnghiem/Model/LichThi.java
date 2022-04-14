package com.example.appthitracnghiem.Model;

public class LichThi {

    private String ngayThi;
    private String tenMonThi;
    private String tenDeThi;
    private int IDDeThi;
    private int IDMonThi;
    private int IDHocSinh;

    public LichThi() {
    }

    public LichThi(String ngayThi, String tenMonThi, int IDMonThi, int IDHocSinh) {
        this.ngayThi = ngayThi;
        this.tenMonThi = tenMonThi;
        this.IDMonThi = IDMonThi;
        this.IDHocSinh = IDHocSinh;
    }

    public String getTenDeThi() {
        return tenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public int getIDDeThi() {
        return IDDeThi;
    }

    public void setIDDeThi(int IDDeThi) {
        this.IDDeThi = IDDeThi;
    }


    public String getThoiGianThi() {
        return ngayThi;
    }

    public void setThoiGianThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getTenMonThi() {
        return tenMonThi;
    }

    public void setTenMonThi(String tenMonThi) {
        this.tenMonThi = tenMonThi;
    }

    public int getIDMonThi() {
        return IDMonThi;
    }

    public void setIDMonThi(int IDMonThi) {
        this.IDMonThi = IDMonThi;
    }

    public int getIDHocSinh() {
        return IDHocSinh;
    }

    public void setIDHocSinh(int IDHocSinh) {
        this.IDHocSinh = IDHocSinh;
    }
}
