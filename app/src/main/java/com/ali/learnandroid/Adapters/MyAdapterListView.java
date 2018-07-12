package com.ali.learnandroid.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.learnandroid.Models.ListRowData;
import com.ali.learnandroid.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapterListView extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ListRowData> arrayList;

    public MyAdapterListView(Context context, ArrayList<ListRowData> arrayList) {
        this.inflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.recycler_row, null);
            holder = new ViewHolder();

            holder.ivProfile = convertView.findViewById(R.id.imgProfileRow);
            holder.tvName = convertView.findViewById(R.id.tvNameRow);
            holder.tvAge = convertView.findViewById(R.id.tvAgeRow);
            holder.tvJob = convertView.findViewById(R.id.tvJobRow);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag() ;
        }

        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvAge.setText(arrayList.get(position).getAge());
        holder.tvJob.setText(arrayList.get(position).getJob());
        holder.ivProfile.setImageURI(Uri.parse(arrayList.get(position).getImgProfile()));
        //OR
        Picasso.
                get().
                load(arrayList.get(position).getImgProfile()).
                fit().error(R.drawable.logo).
                into(holder.ivProfile);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you have clicked "+arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    class ViewHolder{
        TextView tvName, tvAge, tvJob;
        ImageView ivProfile;
    }
}
