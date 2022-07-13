package com.example.splitit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityPhoneAuthBinding;
public class PhoneAuth extends AppCompatActivity {

    ActivityPhoneAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneAuth.this, VerifyPhone.class);
                startActivity(intent);
                finish();
            }
        });

    }
}


