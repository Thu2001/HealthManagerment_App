package com.example.healthmanagerment_app.mainScreen.list;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.donthuoc.DonThuocAdapter;
import com.example.healthmanagerment_app.donthuoc.thuoc;

import java.util.ArrayList;
import java.util.List;

public class list extends Fragment {
    private RecyclerView rcv_donthuoc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
   

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        rcv_donthuoc=view.findViewById(R.id.rcv_donthuoc);
        ArrayList<thuoc> listdonThuoc = new ArrayList<>();
        listdonThuoc.add(new thuoc("Tên Thuốc 1" ,"ngày 3 viên " , "15"));
        DonThuocAdapter donthuocAdapter = new DonThuocAdapter(getActivity(),listdonThuoc);
        LinearLayoutManager LinearLayoutManager=new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
        rcv_donthuoc.setLayoutManager(LinearLayoutManager);
        rcv_donthuoc.setAdapter(donthuocAdapter);
        return view;
    }
}