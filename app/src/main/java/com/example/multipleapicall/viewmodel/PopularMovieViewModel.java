package com.example.multipleapicall.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.multipleapicall.modelclass.DatumResponse;
import com.example.multipleapicall.viewrepo.PopularMovieViewRepo;

public class PopularMovieViewModel extends AndroidViewModel {
    private final PopularMovieViewRepo popularMovieViewRepo;

    public PopularMovieViewModel(@NonNull Application application) {
        super(application);
        popularMovieViewRepo = PopularMovieViewRepo.getInstance(application);
    }

    public LiveData<DatumResponse> getPopularMovieDetails() {
        return popularMovieViewRepo.getPopularMovieDetails();
    }

}
