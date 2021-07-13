package com.example.madcamp_week2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madcamp_week2.DetailPostActivity;
import com.example.madcamp_week2.R;
import com.example.madcamp_week2.model.Post;
import com.example.madcamp_week2.server.RetrofitInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Post> data;
    private  Context context;
    private  String TAG = "GalleryAdapter";
    private String BASE_URL = "http://192.249.18.117:80";
    private Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);


    private OnItemClickListener mListener;
    //private String[] sliderImage;

    int mItemViewType;

    public GalleryAdapter(Context context, ArrayList<Post> list, String[] sliderImage) {
        data = list;
        this.context = context;
        //this.sliderImage = sliderImage;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView restname;
        TextView title;
        //TextView content;
        TextView rate;
        //ImageView img;
        Button btn_detail_review;
        TextView writer;

        public ListViewHolder(@NonNull View itemView, GalleryAdapter.OnItemClickListener listener) {
            super(itemView);

            title = itemView.findViewById(R.id.title_id);
            rate = itemView.findViewById(R.id.rate);
            restname = itemView.findViewById(R.id.name);
            btn_detail_review = itemView.findViewById(R.id.btn_detail_review);
            writer = itemView.findViewById(R.id.tv_writer);


        }

//        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.gallery_item_list, parent, false);
        ListViewHolder vh = new ListViewHolder(view, mListener);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ListViewHolder hld = (ListViewHolder) holder;

        Post post = data.get(position);

        hld.restname.setText(post.getRestName());
        //hld.bindSliderImage(sliderImage[position]);
        hld.title.setText(post.getTitle());
        hld.rate.setText(post.getRate() + "");
        hld.writer.setText("By "+post.getWriterName());

        hld.btn_detail_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPostActivity.class);
                intent.putExtra("postId", post.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItemViewType;
    }



    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
}
