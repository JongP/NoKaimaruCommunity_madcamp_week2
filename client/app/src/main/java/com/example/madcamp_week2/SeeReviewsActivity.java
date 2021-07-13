package com.example.madcamp_week2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.madcamp_week2.adapter.FavoriteAdapter;
import com.example.madcamp_week2.adapter.GalleryAdapter;
import com.example.madcamp_week2.model.Post;
import com.example.madcamp_week2.server.PostResult;
import com.example.madcamp_week2.server.RetrofitInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeeReviewsActivity extends AppCompatActivity {

    RecyclerView rv_seeReviewsByRest;
    GalleryAdapter galleryAdapter;
    LinearLayoutManager linearLayoutManager;
    String restId;
    String TAG = "SeeReviewActivity";
    private ArrayList<Post> arrayList;

    private String BASE_URL = "http://192.249.18.117:80";
    private Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_reviews);

        Intent intent = getIntent();
        restId = intent.getStringExtra("restId");


        rv_seeReviewsByRest = findViewById(R.id.rv_reviewsByRest);
        arrayList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_seeReviewsByRest.setLayoutManager(linearLayoutManager);

        galleryAdapter = new GalleryAdapter(getApplicationContext(),arrayList,null);
        rv_seeReviewsByRest.setAdapter(galleryAdapter);

        serverGetPostByRest();
    }

    private void serverGetPostByRest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("rest",restId);


        Call<List<PostResult>> call = retrofitInterface.executeGetPostByRest(map);

        call.enqueue(new Callback<List<PostResult>>() {
            @Override
            public void onResponse(Call<List<PostResult>> call, Response<List<PostResult>> response) {
                if(response.code()==200){

                    Log.d(TAG, "handle server onResponse");

                    List<PostResult> postlist = response.body();

                    for(PostResult item : postlist){
                        arrayList.add(new Post(item.getId(), item.getTitle(), item.getContent(), item.getRate(), item.getWriter(),item.getWriterName(), item.getRest(), item.getRestName(), item.getPostImg()));
                    }

                    galleryAdapter.notifyDataSetChanged();


                }else if(response.code()==400){

                    Log.d(TAG, "onResponse somehow failed");
                }

            }
            @Override
            public void onFailure(Call<List<PostResult>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Server is closed in SeeReviewActivity", Toast.LENGTH_LONG).show();
                Log.d(TAG, "handle server onFailure in SeeReviewActivty");
            }
        });

    }


}