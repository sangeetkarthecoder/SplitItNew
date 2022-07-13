package com.example.splitit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityPhoneAuthBinding;

public class PhoneAuth extends AppCompatActivity {

        ActivityPhoneAuthBinding binding; 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}


