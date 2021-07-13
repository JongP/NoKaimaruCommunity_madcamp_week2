package com.example.madcamp_week2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.madcamp_week2.server.PostResult;
import com.example.madcamp_week2.server.RestResult;
import com.example.madcamp_week2.server.RetrofitInterface;
import com.example.madcamp_week2.user.UserData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailPostActivity extends AppCompatActivity {

    private String postId;
    private ImageView postImg;
    private String BASE_URL = "http://192.249.18.117:80";
    private Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
            .build();;
    private RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
    private String TAG = "wonderful";
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        Intent intent = getIntent();
        postId = intent.getExtras().getString("postId");

        findViewById(R.id.fb_like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serverAddLike();
            }
        });

        Log.d("finish", "before request_one");
        request_one_post();
        getServerImage();
    }


    private void request_one_post() {

        Log.d("finish", "start request one post");

        HashMap<String , String> map = new HashMap<>();
        map.put("id", postId);

        Log.d("finish", postId);

        Call<PostResult> call = retrofitInterface.executeGetOnePost(map);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        call.enqueue(new Callback<PostResult>() {
            @Override
            public void onResponse(@NotNull Call<PostResult> call, @NotNull Response<PostResult> response) {
                if (response.code() == 200) {

                    PostResult postResult = response.body();

                    TextView restName = findViewById(R.id.post_restaurant_id);
                    TextView rate = findViewById(R.id.post_rate_id);
                    postImg = findViewById(R.id.post_img_id);
                    ImageView gotoRest = findViewById(R.id.btn_goto_rest);
                    TextView title = findViewById(R.id.post_title_id);
                    TextView content = findViewById(R.id.post_content_id);
                    TextView tv_likenumber = findViewById(R.id.tv_likeNum);

                    rate.setText("별점 : " + (Math.round(postResult.getRate() * 10) / 10.0));
                    //new LoadImage().execute(postResult.getPostImg());
                    restName.setText(postResult.getRestName());
                    restName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    title.setText(postResult.getTitle());
                    content.setText(postResult.getContent());
                    tv_likenumber.setText(String.valueOf(postResult.getLikeNum()));

                    gotoRest.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), RestaurantActivity.class);
                            intent.putExtra("restId", postResult.getRest());
                            startActivity(intent);
                        }
                    });

                } else if (response.code() == 400) {
                    Toast.makeText(DetailPostActivity.this, "somehow onresponse failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostResult> call, Throwable t) {
                Toast.makeText(DetailPostActivity.this, "get one post failed", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getServerImage() {
        HashMap<String ,String > map = new HashMap<>();
        map.put("id",postId);

        Call<ResponseBody> call = retrofitInterface.executePostGet(map);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "onResponse: start");
                Log.d(TAG, response.toString());
                InputStream is = null;


                //importatnt
                //if(response.body()!=null) is = response.body().byteStream();
                //if(is==null)  Log.d(TAG, "onResponse: is is null");
                //else bitmap = BitmapFactory.decodeStream(is);


                ResponseBody responseBody = response.body();
                try {
                    byte[] bytes = responseBody.bytes();
                    bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable()  {
                    public void run() {
                        postImg.setImageBitmap(bitmap);
                    }
                }, 3000);


                //Log.d(TAG, bitmap[0].toString());

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFauilure: start");
            }
        });
    }

    private void serverAddLike() {
        HashMap<String , String> map = new HashMap<>();
        map.put("post", postId);
        map.put("user",UserData.getId());

        Call<Void> call = retrofitInterface.executeAddLike(map);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NotNull Call<Void> call, @NotNull Response<Void> response) {
                if (response.code() == 200) {
                    Toast.makeText(DetailPostActivity.this, "liked", Toast.LENGTH_SHORT).show();
                    TextView tv_like = findViewById(R.id.tv_likeNum);
                    int num = Integer.parseInt(tv_like.getText().toString());
                    tv_like.setText(String.valueOf(num+1));
                    FloatingActionButton floatingActionButton = findViewById(R.id.fb_like);
                    floatingActionButton.setImageResource(R.drawable.ic_baseline_favorite_24);
                    floatingActionButton.setBackgroundColor(Color.parseColor("#ff8c75"));

                }else if (response.code() == 201) {
                    Toast.makeText(DetailPostActivity.this, "unliked", Toast.LENGTH_LONG).show();
                    TextView tv_like = findViewById(R.id.tv_likeNum);
                    int num = Integer.parseInt(tv_like.getText().toString());
                    tv_like.setText(String.valueOf(num-1));
                    FloatingActionButton floatingActionButton = findViewById(R.id.fb_like);
                    floatingActionButton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    floatingActionButton.setBackgroundColor(Color.parseColor("#9c9c9c"));
                }
                else if (response.code() == 400) {
                    Toast.makeText(DetailPostActivity.this, "add like 400 fail", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(DetailPostActivity.this, "add failure", Toast.LENGTH_LONG).show();
            }
        });

    }
}
