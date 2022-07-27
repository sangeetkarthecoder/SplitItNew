package com.example.splitit.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.splitit.Adapters.MessagesAdapter;
import com.example.splitit.ModuleClass.Messages;
import com.example.splitit.databinding.ActivityChatBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ChatActivity extends AppCompatActivity {

    MessagesAdapter messagesAdapter;
    ArrayList<Messages> messages;
    ActivityChatBinding binding;
    FirebaseDatabase database;

    String SenderRoom, ReceiverRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        messages = new ArrayList<>();
        messagesAdapter = new MessagesAdapter(this, messages);
        binding.RecyclerView.setAdapter(messagesAdapter);
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String name = getIntent().getStringExtra("name");
        String receiverUID = getIntent().getStringExtra("uid");
        String senderUID = FirebaseAuth.getInstance().getUid();

        SenderRoom = senderUID + receiverUID;
        ReceiverRoom = receiverUID + senderUID;
        database = FirebaseDatabase.getInstance();

        database.getReference().child("Chats")
                        .child(SenderRoom)
                                .child("Messages").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        messages.clear();
                        for(DataSnapshot snapshot1: snapshot.getChildren()) {
                            Messages message = snapshot1.getValue(Messages.class);
                            messages.add(message);
                        }
                        messagesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        binding.sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgTxt = binding.messageBox.getText().toString();

                Date date = new Date();

                Messages messages = new Messages(msgTxt,senderUID,date.getTime());
                binding.messageBox.setText("");
                if(binding.messageBox.getText().toString().equals("")) {
                    binding.messageBox.setError("Empty text");
                }
                database.getReference()
                        .child("Chats")
                        .child(SenderRoom)
                        .child("Messages")
                        .push()
                        .setValue(messages).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                database.getReference()
                                        .child("Chats")
                                        .child(ReceiverRoom)
                                        .child("Messages")
                                        .push()
                                        .setValue(messages).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {

                                            }
                                        });

                            }
                        });


            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}