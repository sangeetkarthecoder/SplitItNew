package com.example.splitit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splitit.ModuleClass.Messages;
import com.example.splitit.R;
import com.example.splitit.databinding.ItemReceivedBinding;
import com.example.splitit.databinding.ItemSentBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Messages> messages;
    final int ITEM_SENT = 1;
    final int ITEM_RECEIVED = 2;

    public MessagesAdapter(Context context, ArrayList<Messages> messages) {
        this.context = context;
        this.messages = messages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType==ITEM_SENT) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_sent, parent, false);
            return new SentViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_received, parent, false);
            return new ReceiveViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Messages message = messages.get(position);
        if(holder.getClass().equals(SentViewHolder.class)) {
            SentViewHolder viewholder = (SentViewHolder) holder;
            viewholder.binding.sentmsg.setText(message.getMessage());
        } else {
            ReceiveViewHolder viewholder = (ReceiveViewHolder) holder;
            viewholder.binding.receivedmsg.setText(message.getMessage());
        }
    }

    @Override
    public int getItemViewType(int position) {

        Messages message = messages.get(position);
        if(FirebaseAuth.getInstance().getUid().equals(message.getSenderID())) {
            return ITEM_SENT;
        } else {
            return ITEM_RECEIVED;
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class SentViewHolder extends RecyclerView.ViewHolder {

        ItemSentBinding binding;
        public SentViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemSentBinding.bind(itemView);
        }
    }

    public class ReceiveViewHolder extends RecyclerView.ViewHolder {

        ItemReceivedBinding binding;
        public ReceiveViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemReceivedBinding.bind(itemView);
        }
    }

}
