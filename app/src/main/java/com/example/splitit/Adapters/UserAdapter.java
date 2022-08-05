package com.example.splitit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.splitit.Activities.ChatActivity;
import com.example.splitit.ModuleClass.User;
import com.example.splitit.R;
import com.example.splitit.databinding.ConversationviewBinding;

import java.util.ArrayList;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.UsersviewHolder>{

    Context context;
    ArrayList<User> users;


    public UserAdapter(Context context,ArrayList<User> users){
        this.context = context;
        this.users = users;

    }
    @NonNull
    @Override
    public UsersviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.conversationview,parent,false);
        return new UsersviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersviewHolder holder, int position) {
        User user = users.get(position);
        holder.binding.personname.setText(user.getName());
        Glide.with(context)
                .load(user.getProfileimage())
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(holder.binding.personimage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("uid", user.getuid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersviewHolder extends RecyclerView.ViewHolder{

        ConversationviewBinding binding;
        public UsersviewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ConversationviewBinding.bind(itemView);
        }
    }


}
