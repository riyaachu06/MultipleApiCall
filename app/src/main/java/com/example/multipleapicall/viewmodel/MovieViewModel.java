package com.example.multipleapicall.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.multipleapicall.modelclass.DatumResponse;
import com.example.multipleapicall.viewrepo.MovieViewRepo;

public class MovieViewModel extends AndroidViewModel {
    private final MovieViewRepo movieViewRepo;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieViewRepo = MovieViewRepo.getInstance(application);
    }
    public LiveData<DatumResponse> getMovieDetails() {
        return movieViewRepo.getMovieDetails();
    }
}
