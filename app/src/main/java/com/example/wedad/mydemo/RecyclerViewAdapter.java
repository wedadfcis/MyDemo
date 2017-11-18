package com.example.wedad.mydemo;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by wedad on 11/14/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

       private List<Filems> filemsList;
       Context context;

    public RecyclerViewAdapter(List<Filems> filemsList,Context context) {
        this.filemsList = filemsList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(filemsList.get(position).getTitle());
       // holder.releaseYear.setText(filemsList.get(position).getReleaseYear());
       // holder.rating.setN(filemsList.get(position).getRating());
        Glide.with(context).load(filemsList.get(position).getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return filemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,rating,releaseYear,gener;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.title);
            rating=(TextView) itemView.findViewById(R.id.rating);
            releaseYear=(TextView) itemView.findViewById(R.id.releaseyear);
            gener=(TextView) itemView.findViewById(R.id.gener);
            image=(ImageView) itemView.findViewById(R.id.image);
        }

    }
}
