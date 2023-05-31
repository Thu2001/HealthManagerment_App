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
