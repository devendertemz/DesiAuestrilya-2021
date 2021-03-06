package com.thetemz.desiaustralia.adapter.desiTv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thetemz.desiaustralia.HomePageDetailsActivity;
import com.thetemz.desiaustralia.R;
import com.thetemz.desiaustralia.model.desitv.LatestData;

import java.util.ArrayList;

public class DesiTvLatestAdapter extends RecyclerView.Adapter<DesiTvLatestAdapter.MyHolder>{


    private LayoutInflater inflater;
    private Context context;
    private ArrayList<LatestData> arrayList;
    public DesiTvLatestAdapter(Context context, ArrayList<LatestData> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.desitv_latest_adapter, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getUrl()
        ).into(holder.imageView);
        holder.titleTv.setText(arrayList.get(position).getTitle());
        holder.dateTv.setText(arrayList.get(position).getDate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomePageDetailsActivity.class);
                intent.putExtra("title", arrayList.get(position).getTitle());
                intent.putExtra("image", arrayList.get(position).getUrl());
                intent.putExtra("desc", arrayList.get(position).getDesc());
                intent.putExtra("date", arrayList.get(position).getDate());
                intent.putExtra("video", arrayList.get(position).getVideo());
                intent.putExtra("page", "desi");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleTv, dateTv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTv = itemView.findViewById(R.id.titleTv);
            dateTv = itemView.findViewById(R.id.dateTv);

        }
    }
}
