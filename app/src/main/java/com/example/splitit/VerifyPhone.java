package com.example.splitit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityVerifyPhoneBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.mukesh.OnOtpCompletionListener;

public class VerifyPhone extends AppCompatActivity {

    ActivityVerifyPhoneBinding binding;
    FirebaseAuth fauth;
    String displayphonenumber = "";
    String pnumber;
    String otp = "";
    String verificationid;

    //getting ifnoof phonenumber and country code and verificationd id from previous intent i.e phonAuth
    private void getifno(){
         pnumber = getIntent().getStringExtra("phonenumber");
        String countrycode = getIntent().getStringExtra("countrycode");
        verificationid = getIntent().getStringExtra("id");

        make_display_phonenumber(countrycode,pnumber);
    }


    //making number in formate (country code then aaa bbb cccc)
    private void make_display_phonenumber(String countrycode,String number){
        displayphonenumber  = countrycode + " " + number.substring(0,3) + " " + number.substring(3,6) + " " + number.substring(6,10);
        binding.phonenumber.setText(displayphonenumber);
    }

    //getting number from number pad and adding this in otpview
    private void inputotp(String number) {
        if (otp.isEmpty()) {
            otp = number;
            binding.otpview.setText(number);
        } else if (otp.length() < 6){
            otp += number;
            binding.otpview.setText(otp);
        }
    }


    //setting up all onclicklistners
    private void setOnclickListerns(){
        binding.number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("number" , binding.number0.getText().toString());
                inputotp(binding.number0.getText().toString());
            }
        });

        binding.number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number1.getText().toString());
            }
        });

        binding.number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number2.getText().toString());
            }
        });


        binding.number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number3.getText().toString());
            }
        });

        binding.number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number4.getText().toString());
            }
        });

        binding.number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number5.getText().toString());
            }
        });

        binding.number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number6.getText().toString());
            }
        });

        binding.number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number7.getText().toString());
            }
        });


        binding.number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number8.getText().toString());
            }
        });

        binding.number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputotp(binding.number9.getText().toString());
            }
        });

        binding.backspacebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!otp.isEmpty()) {
                    otp = otp.substring(0, otp.length() - 1);
                    binding.otpview.setText(otp);
                }
            }
        });

        binding.continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate_and_nextactivity();
            }
        });
        binding.otpview.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid,otp);
            }
        });
    }

    //checking if otp enterd is correct and then signing in to HomeActivity
    private void validate_and_nextactivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //getifno();
        fauth = FirebaseAuth.getInstance();
        setOnclickListerns();

        binding.otpview.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid,binding.otpview.getText().toString());
                
            }
        });








    }
}