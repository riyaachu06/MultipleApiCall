package com.example.multipleapicall.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.multipleapicall.R;
import com.example.multipleapicall.adapter.VerticalRecycleviewAdapter;
import com.example.multipleapicall.databinding.ActivityVerticalBinding;
import com.example.multipleapicall.interfaces.OnItemClickListener;
import com.example.multipleapicall.modelclass.DatumResponse;
import com.example.multipleapicall.modelclass.Result;
import com.example.multipleapicall.viewmodel.MovieViewModel;
import com.example.multipleapicall.viewmodel.PopularMovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class VerticalActivity extends AppCompatActivity implements OnItemClickListener {
    ActivityVerticalBinding activityVerticalBinding;
    VerticalRecycleviewAdapter verticalRecycleviewAdapter;
    private MovieViewModel movieViewModel;
    private PopularMovieViewModel popularMovieViewModel;
    private List<Result> dataset = new ArrayList<>();
    public static final String ITEM = "item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityVerticalBinding = DataBindingUtil.setContentView(this, R.layout.activity_vertical);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        popularMovieViewModel = ViewModelProviders.of(this).get(PopularMovieViewModel.class);
        fetchMovieLists();
        fetchPopularMovieLists();
    }
    private void fetchPopularMovieLists() {
        popularMovieViewModel.getPopularMovieDetails().observe(this, new Observer<DatumResponse>() {
            @Override
            public void onChanged(DatumResponse datumResponse) {
                if (datumResponse.getResults() != null) {
                    for (Result popularmovieresult : datumResponse.getResults()) {
                        Result popoularmovieresultnew = new Result();
                        popoularmovieresultnew.setSinglepopularmovieResult(popularmovieresult);
                        popoularmovieresultnew.setPOPULARMOVIERESULT(true);
                        dataset.add(popoularmovieresultnew);
                        initviews();
                    }
                }
            }
        });

    }

    private void fetchMovieLists() {
        movieViewModel.getMovieDetails().observe(this, new Observer<DatumResponse>() {
            @Override
            public void onChanged(DatumResponse datumResponse) {
                if (datumResponse.getResults() != null) {
                    for (Result movieresult : datumResponse.getResults()) {
                        Result movieresultnew = new Result();
                        movieresultnew.setSingleMovieResult(movieresult);
                        movieresultnew.setMOVIERESULT(true);
                        dataset.add(movieresultnew);
                        initviews();
                    }
                }
            }
        });
    }

    private void initviews() {
        activityVerticalBinding.recycleviewVertical.setHasFixedSize(true);
        verticalRecycleviewAdapter = new VerticalRecycleviewAdapter(getApplicationContext(), dataset);
        activityVerticalBinding.recycleviewVertical.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityVerticalBinding.recycleviewVertical.setAdapter(verticalRecycleviewAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getApplicationContext(), MovieDetailsActvity.class);
        intent.putExtra(ITEM, dataset.get(position));
        startActivity(intent);
    }
}
