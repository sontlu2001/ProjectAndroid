package com.example.appthitracnghiem.Model;

public class ChiTietBaiLam {
    private int soThuTu;
    private int linkAnh;
    private String cauHoi;
    private String dapAnChon;

    public ChiTietBaiLam() {
    }

    public ChiTietBaiLam(int soThuTu, int linkAnh) {
        this.soThuTu = soThuTu;
        this.linkAnh = linkAnh;
    }


    public ChiTietBaiLam(int soThuTu, String cauHoi, String dapAnChon) {
        this.soThuTu = soThuTu;
        this.cauHoi = cauHoi;
        this.dapAnChon = dapAnChon;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public int getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(int linkAnh) {
        this.linkAnh = linkAnh;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDapAnChon() {
        return dapAnChon;
    }

    public void setDapAnChon(String dapAnChon) {
        this.dapAnChon = dapAnChon;
    }
}
