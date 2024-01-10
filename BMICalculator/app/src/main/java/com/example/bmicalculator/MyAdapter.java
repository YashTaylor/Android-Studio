package com.example.bmicalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    public ArrayList RvWeight, RvHeightFT, RvHeight, RvResult;

    public MyAdapter(Context context, ArrayList RvWeight, ArrayList RvHeightFT, ArrayList RvHeight, ArrayList RvResult) {
        this.context = context;
        this.RvWeight = RvWeight;
        this.RvHeightFT = RvHeightFT;
        this.RvHeight = RvHeight;
        this.RvResult = RvResult;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.RvWeight.setText(String.valueOf(RvWeight.get(position)));
        holder.RvHeightFT.setText(String.valueOf(RvHeightFT.get(position)));
        holder.RvHeight.setText(String.valueOf(RvHeight.get(position)));
        holder.RvResult.setText(String.valueOf(RvResult.get(position)));
    }

    @Override
    public int getItemCount() {
        return RvWeight.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView RvWeight, RvHeightFT, RvHeight, RvResult;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            RvWeight = itemView.findViewById(R.id.RvWeight);
            RvHeightFT = itemView.findViewById(R.id.RvHeightFT);
            RvHeight = itemView.findViewById(R.id.RvHeight);
            RvResult = itemView.findViewById(R.id.RvResult);

            itemView.setOnLongClickListener(this);// new added for delete
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show();
//          .remove(position); // ISSUE HERE
            notifyItemRemoved(position);
            return true;
        }
    }
}
