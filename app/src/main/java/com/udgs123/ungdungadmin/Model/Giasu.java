package com.udgs123.ungdungadmin.Model;

public class Giasu {
    private String Id_gs;
    private String  Hoten_gs, Email_gs, Sodienthoai_gs, Diachi_gs, Truongtheohoc_gs,
                    Chuyennganh_gs, Monday_gs, Trinhdo_gs;

    public Giasu(String id_gs, String hoten_gs, String email_gs, String sodienthoai_gs, String diachi_gs,
                 String truongtheohoc_gs, String chuyennganh_gs, String monday_gs, String trinhdo_gs) {
        Id_gs = id_gs;
        Hoten_gs = hoten_gs;
        Email_gs = email_gs;
        Sodienthoai_gs = sodienthoai_gs;
        Diachi_gs = diachi_gs;
        Truongtheohoc_gs = truongtheohoc_gs;
        Chuyennganh_gs = chuyennganh_gs;
        Monday_gs = monday_gs;
        Trinhdo_gs = trinhdo_gs;
    }

    public String getId_gs() {
        return Id_gs;
    }

    public void setId_gs(String id_gs) {
        Id_gs = id_gs;
    }

    public String getHoten_gs() {
        return Hoten_gs;
    }

    public void setHoten_gs(String hoten_gs) {
        Hoten_gs = hoten_gs;
    }

    public String getEmail_gs() {
        return Email_gs;
    }

    public void setEmail_gs(String email_gs) {
        Email_gs = email_gs;
    }

    public String getSodienthoai_gs() {
        return Sodienthoai_gs;
    }

    public void setSodienthoai_gs(String sodienthoai_gs) {
        Sodienthoai_gs = sodienthoai_gs;
    }

    public String getDiachi_gs() {
        return Diachi_gs;
    }

    public void setDiachi_gs(String diachi_gs) {
        Diachi_gs = diachi_gs;
    }

    public String getTruongtheohoc_gs() {
        return Truongtheohoc_gs;
    }

    public void setTruongtheohoc_gs(String truongtheohoc_gs) {
        Truongtheohoc_gs = truongtheohoc_gs;
    }

    public String getChuyennganh_gs() {
        return Chuyennganh_gs;
    }

    public void setChuyennganh_gs(String chuyennganh_gs) {
        Chuyennganh_gs = chuyennganh_gs;
    }

    public String getMonday_gs() {
        return Monday_gs;
    }

    public void setMonday_gs(String monday_gs) {
        Monday_gs = monday_gs;
    }

    public String getTrinhdo_gs() {
        return Trinhdo_gs;
    }

    public void setTrinhdo_gs(String trinhdo_gs) {
        Trinhdo_gs = trinhdo_gs;
    }
}
