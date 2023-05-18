package com.example.healthmanagerment_app.donthuoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.healthmanagerment_app.R;

import java.util.ArrayList;
import java.util.List;

public class viewThuoc extends AppCompatActivity {
    private RecyclerView rcvthuoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_thuoc);
        rcvthuoc=findViewById(R.id.rcv_thuoc);
        ArrayList<thuoc> listThuoc = new ArrayList<>();
        listThuoc.add(new thuoc("Tên Thuốc 1" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 2" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 3" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 4" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 5" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 6" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 4" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 5" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 6" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 4" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 5" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 6" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 4" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 5" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 6" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 4" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 5" ,"ngày 3 viên " , "15 viên"));
        listThuoc.add(new thuoc("Tên Thuốc 6" ,"ngày 3 viên " , "15 viên"));
        DonThuocAdapter donthuocAdapter = new DonThuocAdapter(this,listThuoc);
        LinearLayoutManager LinearLayoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvthuoc.setLayoutManager(LinearLayoutManager);
        rcvthuoc.setAdapter(donthuocAdapter);

    }
    private List<thuoc> getlist(){
        List<thuoc> list=new ArrayList<>();
        list.add(new thuoc("Tên Thuốc 1" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 2" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 3" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 4" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 5" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 6" ,"ngày 3 viên " , "15 viên"));

        return list;
    }
}