package com.example.healthmanagerment_app.chitietthuoc;

import com.example.healthmanagerment_app.model.ResponePrescription;

import java.util.ArrayList;

public class thongtinthuoc {
    public String message;
    public ArrayList<Thongtinthuoc> data;

    public static class Thongtinthuoc {
        public int idT;
        public String codeT;
        public String nameT;
        public String SXT;
        public String addressT;
        public String functionT;
        public String dosageT;
        public String ngaySXT;
        public String ngayHHT;
        public String soluong;

        public String getSoluong() {
            return soluong;
        }

        public void setSoluong(String soluong) {
            this.soluong = soluong;
        }

        public int getIdT() {
            return idT;
        }

        public void setIdT(int idT) {
            this.idT = idT;
        }

        public String getCodeT() {
            return codeT;
        }

        public void setCodeT(String codeT) {
            this.codeT = codeT;
        }

        public String getNameT() {
            return nameT;
        }

        public void setNameT(String nameT) {
            this.nameT = nameT;
        }

        public String getSXT() {
            return SXT;
        }

        public void setSXT(String SXT) {
            this.SXT = SXT;
        }

        public String getAddressT() {
            return addressT;
        }

        public void setAddressT(String addressT) {
            this.addressT = addressT;
        }

        public String getFunctionT() {
            return functionT;
        }

        public void setFunctionT(String functionT) {
            this.functionT = functionT;
        }

        public String getDosageT() {
            return dosageT;
        }

        public void setDosageT(String dosageT) {
            this.dosageT = dosageT;
        }

        public String getNgaySXT() {
            return ngaySXT;
        }

        public void setNgaySXT(String ngaySXT) {
            this.ngaySXT = ngaySXT;
        }

        public String getNgayHHT() {
            return ngayHHT;
        }

        public void setNgayHHT(String ngayHHT) {
            this.ngayHHT = ngayHHT;
        }
    }
}