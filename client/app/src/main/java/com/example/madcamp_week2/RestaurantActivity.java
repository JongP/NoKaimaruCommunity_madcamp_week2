package com.example.madcamp_week2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madcamp_week2.frag.Fragment3;
import com.example.madcamp_week2.server.RestResult;
import com.example.madcamp_week2.server.RetrofitInterface;
import com.example.madcamp_week2.user.UserData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.249.18.117:80";
    private String restId;
    private ImageView restImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent intent = getIntent();
        restId = intent.getExtras().getString("restId");

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                request_one_rest();
                mSwipeRefreshLayout.setRefreshing(false);

            }
        });

        request_one_rest();
    }

    private void request_one_rest() {
        HashMap<String , String> map = new HashMap<>();
        map.put("id", restId);


        Call<RestResult> call = retrofitInterface.executeGetOneRest(map);

        call.enqueue(new Callback<RestResult>() {
            @Override
            public void onResponse(@NotNull Call<RestResult> call, @NotNull Response<RestResult> response) {
                if (response.code() == 200) {

                    RestResult restResult = response.body();

                    TextView restName = findViewById(R.id.rest_name_id);
                    TextView contact = findViewById(R.id.rest_contact_id);
                    TextView rate = findViewById(R.id.rest_rate_id);
                    TextView category = findViewById(R.id.rest_category_id);
                    restImg = findViewById(R.id.rest_image_id);
                    Button write_button = findViewById(R.id.btn_write_review_id);
                    Button favorite_button = findViewById(R.id.btn_favorite_id);
                    Button see_revie_button = findViewById(R.id.btn_see_review_id);

                    restName.setText(restResult.getName());
                    contact.setText(restResult.getContact());
                    category.setText("분류 : " + restResult.getCategory());
                    rate.setText("별점 : " + (Math.round(restResult.getRate() * 10) / 10.0));
                    new LoadImage().execute(restResult.getPhotoURL());
                    restName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

//                    GradientDrawable drawable=
//                            (GradientDrawable) (RestaurantActivity.this).getDrawable(R.drawable.background_rounding);
//                    restImg.setBackground(drawable);
                    restImg.setClipToOutline(true);
                    restImg.setOutlineProvider(new ViewOutlineProvider() {
                        @Override
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 40);
                        }
                    });

                    write_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), WritePostActivity.class);
                            intent.putExtra("restId", restId);
                            startActivity(intent);
                        }
                    });

                    favorite_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            HashMap<String,String> map = new HashMap<>();
                            UserData userData = new UserData();
                            map.put("id", userData.getId());
                            map.put("res", restResult.getId());

                            Call<Void> call_fav = retrofitInterface.executeAddFavorite(map);
                            call_fav.enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call_fav, Response<Void> response) {
                                    Log.d("favoriteTest", "onResponse: ");
                                    if(response.code()==200) Toast.makeText(RestaurantActivity.this, "favorite added", Toast.LENGTH_SHORT).show();
                                    if(response.code()==201) Toast.makeText(RestaurantActivity.this, "favorite already added", Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void onFailure(Call<Void> call_fav, Throwable t) {
                                    Log.d("favoriteTest", "onFailure: ");
                                }
                            });
                        }
                    });

                    contact.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String tel_contact = restResult.getContact();
                            tel_contact = tel_contact.replace("-", "");
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel_contact)));
                        }
                    });

                    see_revie_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(RestaurantActivity.this, SeeReviewsActivity.class);
                            intent.putExtra("restId",restResult.getId());
                            startActivity(intent);
                        }
                    });

                } else if (response.code() == 400) {

                }
            }

            @Override
            public void onFailure(Call<RestResult> call, Throwable t) {


            }
        });

    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(strings[0]).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            restImg.setImageBitmap(bitmap);
        }
    }
}