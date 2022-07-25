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
    private void setOnclickListeners(){
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate_and_register();
            }
        });

        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,Login.class));
            }
        });
    }

    private void validate_and_register(){

        username = binding.inputUsername.getText().toString();
        password = binding.inputPassword.getText().toString();
        String confirmPass = binding.inputConfirmPassword.getText().toString();

        if(username.isEmpty()){
            Toast.makeText(getApplicationContext(),"Username is Empty",Toast.LENGTH_SHORT).show();
        }else if(password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Password is Empty",Toast.LENGTH_SHORT).show();
        }else if(confirmPass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Confirm password is Empty",Toast.LENGTH_SHORT).show();
        }else if ( !password.equals(confirmPass) ) {
            Toast.makeText(getApplicationContext(),"Password dosen't match",Toast.LENGTH_SHORT).show();
        }else{
            auth = FirebaseAuth.getInstance();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setOnclickListeners();

    }
}