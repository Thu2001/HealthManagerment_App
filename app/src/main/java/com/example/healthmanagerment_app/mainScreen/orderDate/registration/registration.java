package com.example.healthmanagerment_app.mainScreen.orderDate.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.chitietthuoc.chitietthuoc;
import com.example.healthmanagerment_app.mainScreen.info.uploadinfo.uploadinfo1;
import com.example.healthmanagerment_app.mainScreen.mainScreen;

public class registration extends AppCompatActivity {
    TextView khoa,ngay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Intent intent= getIntent();
        String id=intent.getStringExtra("spinner");
        String idd=intent.getStringExtra("dateTime");
        khoa=findViewById(R.id.khoa1);
        ngay=findViewById(R.id.ngay);

        khoa.setText(id);ngay.setText(idd);
        Button upload1= findViewById(R.id.home2);
        upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registration.this, mainScreen.class);
                startActivity(intent);
            }
        });
    }
}