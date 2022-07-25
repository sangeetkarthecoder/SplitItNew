package com.example.splitit;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityPhoneAuthBinding;
public class PhoneAuth extends AppCompatActivity {

    ActivityPhoneAuthBinding binding;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
}


