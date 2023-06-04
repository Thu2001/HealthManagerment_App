package com.example.healthmanagerment_app.register;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.model.User;
import com.example.healthmanagerment_app.model.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends Fragment {
    Button register;
    EditText acc,pass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        register = view.findViewById(R.id.register);
        acc = view.findViewById(R.id.editTextText8);
        pass = view.findViewById(R.id.editTextText9);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                User user = new User();
                user.setAccount(acc.getText().toString());
                user.setPassword(pass.getText().toString());
                API methods = RetrofitClient.getRetrofit().create(API.class);
                Call<Data> call = methods.registerUser(user);
                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {

                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                    }
                });
                Navigation.findNavController(view).navigate(R.id.action_register_to_login2);
            }
        });


        return view;
    }
}