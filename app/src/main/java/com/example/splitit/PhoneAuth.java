package com.example.splitit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityPhoneAuthBinding;
public class PhoneAuth extends AppCompatActivity {

    ActivityPhoneAuthBinding binding;
    String phonenumberString ="";

    void make_phonenumber(String number){
        if(phonenumberString.isEmpty()){
            phonenumberString = number;
        }else{
            phonenumberString = phonenumberString+number;
        }
            binding.phonenumber.setText(phonenumberString);

    }

    public void gotoverifyactivity(){
        startActivity(new Intent(PhoneAuth.this,VerifyPhone.class));
        if(phonenumberString.isEmpty()){
            Toast.makeText(getApplicationContext(),"Phone Number is Empty",Toast.LENGTH_SHORT).show();
        }else  if ( phonenumberString.length() < 10 ){
            Toast.makeText(getApplicationContext(),"Phone number has only "  ,Toast.LENGTH_SHORT).show();
        }
    }
    private void setonclicklisteners(){
        binding.number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("number" , binding.number0.getText().toString());
                make_phonenumber(binding.number0.getText().toString());
            }
        });

        binding.number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number1.getText().toString());
            }
        });

        binding.number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("number" , binding.number2.getText().toString());
                make_phonenumber(binding.number2.getText().toString());
            }
        });


        binding.number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number3.getText().toString());
            }
        });

        binding.number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number4.getText().toString());
            }
        });

        binding.number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number5.getText().toString());
            }
        });

        binding.number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number6.getText().toString());
            }
        });

        binding.number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number7.getText().toString());
            }
        });


        binding.number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number8.getText().toString());
            }
        });

        binding.number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_phonenumber(binding.number9.getText().toString());
            }
        });

        binding.backspacebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( !phonenumberString.isEmpty() ){

                    phonenumberString = phonenumberString.substring(0,phonenumberString.length()-1);
                    Log.i("phone number ", phonenumberString);
                    binding.phonenumber.setText(phonenumberString);
                }
            }
        });

        binding.continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoverifyactivity();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setonclicklisteners();

    }
}


