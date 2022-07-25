package com.example.splitit;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.splitit.databinding.FragmentFriendBinding;

public class Friend_Fragment extends Fragment {

    FragmentFriendBinding binding;
    UserAdapter userAdapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Log.i("fjsdafk","jfdskalfjdsalfjdsklafjdklsafjdsaklf");


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}