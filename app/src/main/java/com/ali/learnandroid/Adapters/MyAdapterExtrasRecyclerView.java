package com.ali.learnandroid.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.learnandroid.Models.RecyclerRowData;
import com.ali.learnandroid.R;

import java.util.ArrayList;

public class MyAdapterExtrasRecyclerView extends RecyclerView.Adapter<MyAdapterExtrasRecyclerView.MyViewHolder> {

    private ArrayList<RecyclerRowData> arrayList;
    ItemClickListener listener;

    public interface ItemClickListener{
        void itemClicked(View view, int position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvAge, tvJob;
        private ImageView imgProfile;


        public MyViewHolder(View view)  {
            super(view);
            tvName =  view.findViewById(R.id.tvNameRow);
            tvAge =  view.findViewById(R.id.tvAgeRow);
            tvJob =  view.findViewById(R.id.tvJobRow);
            imgProfile =  view.findViewById(R.id.imgProfileRow);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.itemClicked(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    public MyAdapterExtrasRecyclerView(ArrayList<RecyclerRowData> arrayList1, ItemClickListener clickListener) {
        listener = clickListener;
        arrayList = arrayList1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvAge.setText(arrayList.get(position).getAge());
        holder.tvJob.setText(arrayList.get(position).getJob());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}

