package com.thetemz.desiaustralia.adapter;

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
import com.thetemz.desiaustralia.model.newsletter.DataItems;

import java.util.ArrayList;

public class NewsLetterAdapter extends RecyclerView.Adapter<NewsLetterAdapter.MyHolder>  {


    private Context context;
    private ArrayList<DataItems> arrayList;
    private LayoutInflater inflater;
    private String page;
    public NewsLetterAdapter(Context context, ArrayList<DataItems> arrayList, String page){
        this.context = context;
        this.arrayList = arrayList;
        this.page = page;

    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.newsletter_adapter_layout, null);
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
                intent.putExtra("page", page);
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
