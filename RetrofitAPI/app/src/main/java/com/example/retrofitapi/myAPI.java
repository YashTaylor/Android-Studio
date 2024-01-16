package com.example.retrofitapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface myAPI {

    @GET("posts")
    Call<List<Model>> getModels();

    @FormUrlEncoded
    @POST("posts")
    Call<Model> postModels(@Field("userId") int userId, @Field("title") String title, @Field("body") String body);

    @PUT("posts/{id}")
    Call<Model> putModels(@Path("id") int id, @Body Model model);

    @PATCH("posts/{id}")
    Call<Model> patchModels(@Path("id") int id, @Body Model model);

    @DELETE("posts/{id}")
    Call<Void> deleteMethod(@Path("id") int id);
}
