package com.moutamid.spintowinadmin;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyData> itemsList;

    public MyAdapter(List<MyData> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyData item = itemsList.get(position);
        holder.mobileNumber.setText(item.getMobileNumber());
        holder.userName.setText(item.getUserName());
        holder.amountReq.setText(String.valueOf(item.getAmountReq()));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mobileNumber;
        TextView amountReq;
        TextView userName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mobileNumber = itemView.findViewById(R.id.mobileNumber);
            amountReq = itemView.findViewById(R.id.amountReq);
            userName = itemView.findViewById(R.id.userName);
        }
    }
}


