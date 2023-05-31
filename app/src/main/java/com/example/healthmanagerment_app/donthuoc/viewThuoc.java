package com.example.healthmanagerment_app.donthuoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.model.Data;
import com.example.healthmanagerment_app.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class viewThuoc extends AppCompatActivity {
    private RecyclerView rcvthuoc;
    TextView name;
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

        ThuocAdapter donthuocAdapter = new ThuocAdapter(this,listThuoc);
        LinearLayoutManager LinearLayoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvthuoc.setLayoutManager(LinearLayoutManager);
        rcvthuoc.setAdapter(donthuocAdapter);

        name = findViewById(R.id.usernamehome);
        User user = new User();
        user.setAccount("1");
        Log.v("aaaaaaaaa",new Gson().toJson(user));

        API methods = RetrofitClient.getRetrofit().create(API.class);

        Call<Data> call = methods.getInfo(user);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data dt = response.body();
                name.setText(dt.data.get(0).getUserName().toString());

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }

        });

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