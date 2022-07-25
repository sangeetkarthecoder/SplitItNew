package com.example.splitit;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.splitit.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;

    Friend_Fragment friend_fragment;
    Group_Fragment group_fragment;
    Notification_Fragment notification_fragment;
    Profile_Fragment  profile_fragment;

    BottomNavigationView navBar;
    private void itemselectedfromnavigationbar(){
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
            Log.i("shviajdkfj","fjskdfaklsdjf");
            return false;
        });

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        friend_fragment = new Friend_Fragment();
        group_fragment = new Group_Fragment();
        notification_fragment = new Notification_Fragment();
        profile_fragment = new Profile_Fragment();
        Log.i("fjalsdkfjkdls","fjaklsdfjkladsfjkldsjf");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentview,friend_fragment ).commit();
        itemselectedfromnavigationbar();
        Log.i("Reaching here","sdjfkldsfj");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}