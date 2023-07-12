package com.example.healthmanagerment_app.model;

import java.util.ArrayList;

public class ResponePrescription {
    public String message;
    public ArrayList<Prescription> data;
    public static class Prescription{
        public String namePres;
        public String idPres;
        public String putDate;
        public int status;
        public String url_link_qr_code;

        public String getUrl_link_qr_code() {
            return url_link_qr_code;
        }

        public void setUrl_link_qr_code(String url_link_qr_code) {
            this.url_link_qr_code = url_link_qr_code;
        }

        public String getNamePres() {
            return namePres;
        }

        public void setNamePres(String namePres) {
            this.namePres = namePres;
        }

        public String getIdPres() {
            return idPres;
        }

        public void setIdPres(String idPres) {
            this.idPres = idPres;
        }

        public String getPutDate() {
            return putDate;
        }

        public void setPutDate(String putDate) {
            this.putDate = putDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
