package com.moutamid.spintowinadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.amountReq.setText(String.valueOf(item.getAmountReq()));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mobileNumber;
        TextView amountReq;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mobileNumber = itemView.findViewById(R.id.mobileNumber);
            amountReq = itemView.findViewById(R.id.amountReq);
        }
    }
}
