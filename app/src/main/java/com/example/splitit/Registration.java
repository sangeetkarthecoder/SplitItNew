package com.example.splitit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityRegistrationBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    ActivityRegistrationBinding binding;
    String username,password;

    FirebaseAuth auth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}