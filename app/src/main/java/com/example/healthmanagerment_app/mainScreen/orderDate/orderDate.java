package com.example.healthmanagerment_app.mainScreen.orderDate;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.mainScreen.info.uploadinfo.uploadinfo1;
import com.example.healthmanagerment_app.mainScreen.orderDate.dateTimePicker.TimeManagement;
import com.example.healthmanagerment_app.mainScreen.orderDate.registration.registration;
import com.example.healthmanagerment_app.model.Data;
import com.example.healthmanagerment_app.model.Order;
import com.example.healthmanagerment_app.model.User;
import com.google.gson.Gson;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class orderDate extends Fragment {
    TimeManagement mTimeManagement;

    Button order;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order_date, container, false);

        EditText dateTime = view.findViewById(R.id.editText_date);

        order = view.findViewById(R.id.button_order);

        final Calendar c = Calendar.getInstance();
        dateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dateTime.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order1 = new Order();
                order1.setPutDate(dateTime.getText().toString());
                Log.v("abcd",new Gson().toJson(order1));
                API methods = RetrofitClient.getRetrofit().create(API.class);
                Call<Data> call = methods.order(order1);
                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {

                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                    }
                });
                Toast.makeText(getActivity(),"Đặt lịch thành công",Toast.LENGTH_LONG).show();



                    Intent intent = new Intent(getActivity(), registration.class);
                    getActivity().startActivity(intent);

            }
        });



        return view;
    }
}