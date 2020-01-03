package com.example.multipleapicall.interfaces;



import com.example.multipleapicall.modelclass.DatumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface {

    @GET("3/movie/now_playing")
     Call<DatumResponse> getMovieDetails(@Query("api_key") String api_key);

    @GET("3/movie/popular")
    Call<DatumResponse> getPopoularMovieDetails(@Query("api_key") String api_key);




}
