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
//    public ArrayList RvWeight, RvHeightFT, RvHeight, RvResult;
    private ArrayList<Model> dataList = new ArrayList<Model>();

    public MyAdapter(Context context, ArrayList<Model> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Model model = dataList.get(position);
        holder.RvWeight.setText(String.valueOf(model.getWeight()));
        holder.RvHeightFT.setText(String.valueOf(model.getHeightFT()));
        holder.RvHeight.setText(String.valueOf(model.getHeight()));
        holder.RvResult.setText(String.valueOf(model.getResult()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView RvWeight, RvHeightFT, RvHeight, RvResult;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            RvWeight = itemView.findViewById(R.id.RvWeight);
            RvHeightFT = itemView.findViewById(R.id.RvHeightFT);
            RvHeight = itemView.findViewById(R.id.RvHeight);
            RvResult = itemView.findViewById(R.id.RvResult);

            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(context, "Deleted", Toast.LENGTH_LONG).show();
            dataList.remove(position);
            notifyItemRemoved(position);
            return true;
        }
    }
}
