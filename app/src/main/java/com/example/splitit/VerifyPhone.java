package com.example.splitit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityVerifyPhoneBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;

public class VerifyPhone extends AppCompatActivity {

    ActivityVerifyPhoneBinding binding;

    ActivityVerifyPhoneBinding binding;
    FirebaseAuth auth;
    String verificationID;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVerifyPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String Phone_number = "+" + getIntent().getStringExtra("phone_number");

        binding.verifytw.setText("Verify " + Phone_number);
        auth = FirebaseAuth.getInstance();

        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(Phone_number)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(VerifyPhone.this)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                    }

                    @Override
                    public void onCodeSent(@NonNull String verifyID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(verifyID, forceResendingToken);
                        verificationID = verifyID;
                    }
                })

                .build();

        PhoneAuthProvider.verifyPhoneNumber(options);

        binding.contbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = binding.otpv.getText().toString();

                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, otp);

                auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent intent = new Intent(VerifyPhone.this, MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        }
                        else{
                            Toast.makeText(VerifyPhone.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Intent intent = new Intent(VerifyPhone.this, MainActivity.class);
                startActivity(intent);
            }
        });
}








    }
}