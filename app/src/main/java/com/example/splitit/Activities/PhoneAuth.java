package com.example.splitit.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityPhoneAuthBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneAuth extends AppCompatActivity {

    ActivityPhoneAuthBinding binding;
    Dialog dialog;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cc = binding.CP.getSelectedCountryCode();
                String phone_num = binding.phoneNum.getText().toString();

                if(phone_num.isEmpty()) {
                    binding.phoneNum.setError("Phone number cannot be empty");
                    return;
                }
                else {
                    Intent intent = new Intent(PhoneAuth.this, VerifyPhone.class);
                    intent.putExtra("phone_number", cc+phone_num);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null)
            startActivity(new Intent(PhoneAuth.this, Home.class));
    }
}


