package com.example.splitit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityPhoneAuthBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneAuth extends AppCompatActivity {

        ActivityPhoneAuthBinding binding; 
        FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
    }
}


