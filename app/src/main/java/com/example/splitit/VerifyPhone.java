package com.example.splitit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityPhoneAuthBinding;
import com.example.splitit.databinding.ActivityVerifyPhoneBinding;

public class VerifyPhone extends AppCompatActivity {

    ActivityVerifyPhoneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.otpv.requestFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(binding.otpv, InputMethodManager.SHOW_IMPLICIT);
    }
}