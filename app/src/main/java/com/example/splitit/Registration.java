package com.example.splitit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Registration extends AppCompatActivity {

    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        linear = findViewById(R.id.signin);

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
            }
        });
    }
}