package com.udgs123.ungdungadmin.Model;

public class Hocvien {
    private String Tentaikhoan_hv;
    private String Hoten_hv;
    private String Email_hv;
    private  String Sdt_hv;
    private String Diachi_hv;


    public Hocvien(String tentaikhoan_hv, String hoten_hv, String email_hv, String sdt_hv, String diachi_hv) {
        Hoten_hv = hoten_hv;
        Email_hv = email_hv;
        Sdt_hv = sdt_hv;
        Diachi_hv = diachi_hv;
    }

    public String getTentaikhoan_hv() {
        return Tentaikhoan_hv;
    }

    public void setTentaikhoan_hv(String tentaikhoan_hv) {
        Tentaikhoan_hv = tentaikhoan_hv;
    }

    public String getHoten_hv() {
        return Hoten_hv;
    }

    public void setHoten_hv(String hoten_hv) {
        Hoten_hv = hoten_hv;
    }

    public String getEmail_hv() {
        return Email_hv;
    }

    public void setEmail_hv(String email_hv) {
        Email_hv = email_hv;
    }

    public String getSdt_hv() {
        return Sdt_hv;
    }

    public void setSdt_hv(String sdt_hv) {
        Sdt_hv = sdt_hv;
    }

    public String getDiachi_hv() {
        return Diachi_hv;
    }

    public void setDiachi_hv(String diachi_hv) {
        Diachi_hv = diachi_hv;
    }
}
