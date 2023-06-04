package com.example.healthmanagerment_app.mainScreen.Notification;

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
import com.example.healthmanagerment_app.model.RpCalender;
import com.example.healthmanagerment_app.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class notification extends Fragment {
    RecyclerView rcv_notification;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        rcv_notification=view.findViewById(R.id.rcv_thongbao);
        String data = getArguments().getString("data");
        User user = new User();
        user.setAccount(data);
        API methods = RetrofitClient.getRetrofit().create(API.class);
        Call<RpCalender> call = methods.getListNotification(user);
        call.enqueue(new Callback<RpCalender>() {
            @Override
            public void onResponse(Call<RpCalender> call, Response<RpCalender> response) {
                RpCalender data = response.body();

                ArrayList<RpCalender.Calender> listdonThuoc = new ArrayList<>();
                for (RpCalender.Calender dt:data.data
                ) {
                    listdonThuoc.add(dt);
                }
                NotificationAdapter donthuocAdapter = new NotificationAdapter(getActivity(),listdonThuoc);
                LinearLayoutManager LinearLayoutManager=new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false);
                rcv_notification.setLayoutManager(LinearLayoutManager);
                rcv_notification.setAdapter(donthuocAdapter);
            }

            @Override
            public void onFailure(Call<RpCalender> call, Throwable t) {

            }
        });
        return view;
    }
}