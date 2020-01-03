package com.example.multipleapicall.viewrepo;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.multipleapicall.apiclient.ApiClientMovie;
import com.example.multipleapicall.modelclass.DatumResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMovieViewRepo {
    private static String api_key = "8a940d7709a57a2398b0f39f63ce3f30";
    private static PopularMovieViewRepo repoInstance;
    private final Application application;

    public PopularMovieViewRepo(Application application) {
        this.application = application;
    }

    public static PopularMovieViewRepo getInstance(Application application) {
        if (repoInstance == null) {
            repoInstance = new PopularMovieViewRepo(application);
        }
        return repoInstance;
    }

    public LiveData<DatumResponse> getPopularMovieDetails() {

        final MutableLiveData<DatumResponse> mutableLiveData = new MutableLiveData<>();
        Call<DatumResponse> call;
        call = ApiClientMovie.getInstance(application).getPopoularMovieDetails().getPopoularMovieDetails(api_key);
        call.enqueue(new Callback<DatumResponse>() {
            @Override
            public void onResponse(Call<DatumResponse> call, Response<DatumResponse> response) {
                if (response != null) {

                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DatumResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;


    }
}
