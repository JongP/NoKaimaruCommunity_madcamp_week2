package com.example.madcamp_week2.server;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Streaming;

public interface RetrofitInterface {

    @POST("/post/add")
    Call<Void> executePostAdd(@Body HashMap<String,String> map);

    @GET("/post/getall")
    Call<List<PostResult>> executeGetAllPost();

    @POST("/post/getbyrest")
    Call<List<PostResult>> executeGetPostByRest(@Body HashMap<String,String> map);

    @Streaming
    @POST("/post/getphoto")
    Call<ResponseBody> executePostGet(@Body HashMap<String,String> map);

    @Multipart
    @POST("/post/addtest")
    Call<Void> executePostAddTest(@Part MultipartBody.Part postImg, @PartMap HashMap<String, RequestBody> map);

    @POST("/post/getone")
    Call<PostResult> executeGetOnePost(@Body HashMap<String, String> map);

    @POST("/post/addlike")
    Call<Void> executeAddLike(@Body HashMap<String, String> map);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @POST("/user/add")
    Call<Void> executeSignup(@Body HashMap<String,String> map);


    @POST("/user/getfavorites")
    Call<List<RestResult>> executeGetMyFavorites(@Body HashMap<String, String> map);

    @POST("/user/addfavorite")
    Call<Void> executeAddFavorite(@Body HashMap<String ,String> map);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @POST("/rest/getone")
    Call<RestResult> executeGetOneRest(@Body HashMap<String, String> map);

    @GET("/rest/getall")
    Call<List<RestResult>> executeGetAllRest();

}
