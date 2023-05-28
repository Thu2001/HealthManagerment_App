package com.example.healthmanagerment_app.mainScreen.list;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.donthuoc.DonThuocAdapter;
import com.example.healthmanagerment_app.donthuoc.thuoc;
import com.example.healthmanagerment_app.model.Data;
import com.example.healthmanagerment_app.model.ResponePrescription;
import com.example.healthmanagerment_app.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        User user = new User();
        user.setAccount("1");
        API methods = RetrofitClient.getRetrofit().create(API.class);
        Call<ResponePrescription> call = methods.getListPrescription(user);

        call.enqueue(new Callback<ResponePrescription>() {
            @Override
            public void onResponse(Call<ResponePrescription> call, Response<ResponePrescription> response) {
                ResponePrescription data = response.body();

                ArrayList<ResponePrescription.Prescription> listdonThuoc = new ArrayList<>();
                for (ResponePrescription.Prescription dt:data.data
                     ) {
                    listdonThuoc.add(dt);
                }
                DonThuocAdapter donthuocAdapter = new DonThuocAdapter(getActivity(),listdonThuoc);
                LinearLayoutManager LinearLayoutManager=new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
                rcv_donthuoc.setLayoutManager(LinearLayoutManager);
                rcv_donthuoc.setAdapter(donthuocAdapter);
            }

            @Override
            public void onFailure(Call<ResponePrescription> call, Throwable t) {

            }
        });
        return view;
    }
}