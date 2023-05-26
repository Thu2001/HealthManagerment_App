package com.example.healthmanagerment_app.mainScreen.list;

public class donthuoc {
    private String tendonthuoc;
    private String ngaykham;
    private int nhacnho;

    public donthuoc(String tendonthuoc, String ngaykham, int nhacnho) {
        this.tendonthuoc = tendonthuoc;
        this.ngaykham = ngaykham;
        this.nhacnho = nhacnho;
    }

    public String getTendonthuoc() {
        return tendonthuoc;
    }

    public void setTendonthuoc(String tendonthuoc) {
        this.tendonthuoc = tendonthuoc;
    }

    public String getNgaykham() {
        return ngaykham;
    }

    public void setNgaykham(String ngaykham) {
        this.ngaykham = ngaykham;
    }

    public int getNhacnho() {
        return nhacnho;
    }

    public void setNhacnho(int nhacnho) {
        this.nhacnho = nhacnho;
    }
}
