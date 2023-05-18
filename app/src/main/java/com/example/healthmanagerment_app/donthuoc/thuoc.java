package com.example.healthmanagerment_app.donthuoc;

public class thuoc {
    private String tenthuoc;
    private String lieuluong;
    private String soluong;

    public thuoc(String tenthuoc, String lieuluong, String soluong) {
        this.tenthuoc = tenthuoc;
        this.lieuluong = lieuluong;
        this.soluong = soluong;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getLieuluong() {
        return lieuluong;
    }

    public void setLieuluong(String lieuluong) {
        this.lieuluong = lieuluong;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
