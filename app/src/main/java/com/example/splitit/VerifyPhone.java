package com.example.splitit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityVerifyPhoneBinding;

public class VerifyPhone extends AppCompatActivity {
        ActivityVerifyPhoneBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());









    }
}