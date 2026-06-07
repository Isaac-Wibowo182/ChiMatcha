package com.example.chimatcha;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends
        RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    ItemActivity activity;
    ArrayList<MatchaModel> list;

    public ItemAdapter(
            ItemActivity activity,
            ArrayList<MatchaModel> list){

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view =
                LayoutInflater.from(activity).inflate(
                                R.layout.item_card,
                                parent,
                                false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        MatchaModel item =
                list.get(position);

        holder.txtName
                .setText(item.getName());

        holder.imgMatcha
                .setImageResource(
                        item.getImage());

        holder.itemView
                .setOnClickListener(v -> {

                    Intent intent =
                            new Intent(
                                    activity,
                                    ItemDetailActivity.class);

                    intent.putExtra(
                            "name",
                            item.getName());

                    intent.putExtra(
                            "image",
                            item.getImage());

                    activity.startActivity(intent);

                    activity.overridePendingTransition(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out);
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder
            extends RecyclerView.ViewHolder{

        ImageView imgMatcha;
        TextView txtName;

        public ViewHolder(
                @NonNull View itemView) {

            super(itemView);

            imgMatcha =
                    itemView.findViewById(
                            R.id.imgMatcha);

            txtName =
                    itemView.findViewById(
                            R.id.txtName);
        }
    }
}