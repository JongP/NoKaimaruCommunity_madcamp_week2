package com.example.madcamp_week2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madcamp_week2.R;
import com.example.madcamp_week2.RestaurantActivity;
import com.example.madcamp_week2.server.PostResult;
import com.example.madcamp_week2.server.RestResult;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private ArrayList<RestResult> arrayList;

    public FavoriteAdapter(ArrayList<RestResult> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item,parent,false);
        FavoriteAdapter.ViewHolder holder = new FavoriteAdapter.ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FavoriteAdapter.ViewHolder holder, int position) {

        holder.tv_favName.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv_favName;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tv_favName = itemView.findViewById(R.id.tv_favName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        RestResult restResult = arrayList.get(pos);
                        Intent intent = new Intent(v.getContext(), RestaurantActivity.class);
                        intent.putExtra("restId",restResult.getId());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        v.getContext().startActivity(intent);
                    }
                }
            });

        }
    }
}
