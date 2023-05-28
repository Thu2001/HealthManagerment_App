package com.example.healthmanagerment_app.model;

import java.util.ArrayList;

public class ResponePrescription {
    public String message;
    public ArrayList<Prescription> data;
    public class Prescription{
        public String namePres;
        public String putDate;
        public int status;
    }
}
