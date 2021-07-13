package com.example.madcamp_week2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madcamp_week2.server.RetrofitInterface;
import com.example.madcamp_week2.user.UserData;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WritePostActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.249.18.117:80";
    private String restId;
    private final int GET_GALLERY_IMAGE = 200;
    Uri selectedImageUri = null;
    float rate;

    EditText editTitle;
    EditText editContent;
    Button addImage_button;
    Button upload_button;
    ImageView iv_addImage;
//    RadioButton[] rateButtons = new RadioButton[5];
    TextView warning;
    RatingBar ratingBar;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        Intent intent = getIntent();
        restId = intent.getExtras().getString("restId");

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        editTitle = findViewById(R.id.edit_title_id);
        editContent = findViewById(R.id.edit_content_id);
        addImage_button = findViewById(R.id.btn_add_img_id);
        upload_button = findViewById(R.id.upload_id);
        iv_addImage = findViewById(R.id.iv_add_img_id);
        score = findViewById(R.id.write_rate);
        ratingBar = findViewById(R.id.write_ratingBar);

//        rateButtons[0] = findViewById(R.id.rg_btn0);
//        rateButtons[1] = findViewById(R.id.rg_btn1);
//        rateButtons[2] = findViewById(R.id.rg_btn2);
//        rateButtons[3] = findViewById(R.id.rg_btn3);
//        rateButtons[4] = findViewById(R.id.rg_btn4);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                score.setText(rating + "점");
                rate = rating;
            }
        });

        addImage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });

        Log.d("sat", "writePostActivity onCreate");

        upload_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("sat", "post upload button onClick");

                if (editTitle.getText().toString().length() == 0 || editContent.getText().toString().length() == 0 || selectedImageUri == null || rate == 0.0)
                {
                    warning = findViewById(R.id.warning_id);
                    warning.setText("! 제목과 본문, 이미지, 별점을 모두 작성해주세요 !");
                    return;
                }

                sendPostTest(rate);

                Log.d("sat", "sendPost done");

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

            selectedImageUri = data.getData();
            iv_addImage.setImageURI(selectedImageUri);
            Log.d("sat", selectedImageUri.toString());
            //content://media/external/images/media/40

        }
    }

    private void sendPostTest(float rateNum) {

        Log.d("sat", "start sendPostTest");
        HashMap<String,RequestBody> map =  new HashMap<>();


        RequestBody title = RequestBody.create(MediaType.parse("text/plain"),editTitle.getText().toString());
        RequestBody content = RequestBody.create(MediaType.parse("text/plain"),editContent.getText().toString());
        RequestBody rate = RequestBody.create(MediaType.parse("text/plain"),rateNum + "");
        RequestBody rest = RequestBody.create(MediaType.parse("text/plain"),restId);
        RequestBody user = RequestBody.create(MediaType.parse("text/plain"),UserData.getId());

        map.put("title",title);
        map.put("content",content);
        map.put("rate", rate);
        map.put("rest",rest);
        map.put("user",user);

        Log.d("sat", "map put done");

        //filepath는 String 변수로 갤러리에서 이미지를 가져올 때 photoUri.getPath()를 통해 받아온다.
        File file = new File(selectedImageUri.getPath());
        InputStream inputStream = null;
        try {
            inputStream = getApplicationContext().getContentResolver().openInputStream(selectedImageUri);
        }catch(IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), byteArrayOutputStream.toByteArray());
        MultipartBody.Part uploadFile = MultipartBody.Part.createFormData("postImg", file.getName() ,requestBody);

        Log.d("sat", "before call");

        Call<Void> call = retrofitInterface.executePostAddTest(uploadFile,map);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.code()==200)
                {
                    Toast.makeText(WritePostActivity.this, "Post upload succeed", Toast.LENGTH_LONG).show();
                    Log.d("sat", "post upload");
                }else{
                    Log.d("sat", "Post upload failed : onResponse");
                    Toast.makeText(WritePostActivity.this, "Post upload failed : onResponse", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(WritePostActivity.this, "Post upload failed : onFailure", Toast.LENGTH_LONG).show();

            }
        });
    }

//    private void getServerImage() {
//        HashMap<String ,String > map = new HashMap<>();
//        map.put("title","wowowowowowo");
//
//        Call<ResponseBody> call = retrofitInterface.executePostGet(map);
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.d(TAG, "onResponse: start");
//                Log.d(TAG, response.toString());
//
//                InputStream is = response.body().byteStream();
//                if(is==null)  Log.d(TAG, "onResponse: is is null");
//
//                Bitmap bitmap = BitmapFactory.decodeStream(is);
//                if(bitmap!=null) iv_getImg.setImageBitmap(bitmap);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d(TAG, "onFauilure: start");
//                Toast.makeText(WritePostActivity.this, "getServerImage failed", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
}