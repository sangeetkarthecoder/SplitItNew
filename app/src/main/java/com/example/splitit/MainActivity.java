package com.example.splitit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding binding;
    BottomNavigationView navBar;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startActivity(new Intent(MainActivity.this,PhoneAuth.class));
        Friend_Fragment friend_fragment = new Friend_Fragment();
        Group_Fragment group_fragment = new Group_Fragment();
        Notification_Fragment notification_fragment = new Notification_Fragment();
        Profile_Fragment  profile_fragment = new Profile_Fragment();
        navBar = findViewById(R.id.navigationbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentview,friend_fragment).commit();


        binding.navigationbar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.friend:

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentview,friend_fragment).commit();
                    navBar.getMenu().getItem(0).setChecked(true);
                    break;

                case R.id.groups:

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentview,group_fragment).commit();
                    navBar.getMenu().getItem(1).setChecked(true);
                    break;

                case R.id.notification:

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentview,notification_fragment).commit();
                    navBar.getMenu().getItem(2).setChecked(true);
                    break;

                case R.id.profile:

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentview,profile_fragment).commit();
                    navBar.getMenu().getItem(3).setChecked(true);
                    break;
            }
            return false;
        });

    }
}

