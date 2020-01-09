package com.example.multipleapicall.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
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
        initviews();
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        popularMovieViewModel = ViewModelProviders.of(this).get(PopularMovieViewModel.class);
        fetchMovieLists();
        fetchPopularMovieLists();
    }

    private void fetchMovieLists() {
        movieViewModel.getMovieDetails().observe(this, new Observer<DatumResponse>() {
            @Override
            public void onChanged(DatumResponse datumResponse) {
                if (datumResponse.getResults() != null) {
                    Result movieresultnew = new Result();
                    movieresultnew.setAllMovieSet(true);
                    movieresultnew.setMovieSet(datumResponse.getResults());
                    dataset.add(0,movieresultnew);
                    verticalRecycleviewAdapter.notifyItemChanged(0);
                }
            }
        });
    }

    private void fetchPopularMovieLists() {
        popularMovieViewModel.getPopularMovieDetails().observe(this, new Observer<DatumResponse>() {
            @Override
            public void onChanged(DatumResponse datumResponse) {
                if (datumResponse.getResults() != null) {
                    Result popularmovieresultnew = new Result();
                    popularmovieresultnew.setPopularMovieSet(true);
                    popularmovieresultnew.setMovieSet(datumResponse.getResults());
                    dataset.add(popularmovieresultnew);

                    Result shareapp = new Result();
                    shareapp.setShareApp(true);
                    dataset.add(shareapp);

                    Result location = new Result();
                    location.setLocation(true);
                    dataset.add(1,location);

                    verticalRecycleviewAdapter.notifyItemRangeChanged(1,datumResponse.getResults().size()-1);
                }
            }
        });
    }

    private void initviews() {
        verticalRecycleviewAdapter = new VerticalRecycleviewAdapter(getApplicationContext(), dataset);
        activityVerticalBinding.recycleviewVertical.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        verticalRecycleviewAdapter.setOnItemClickListener(this);
        activityVerticalBinding.recycleviewVertical.setAdapter(verticalRecycleviewAdapter);
    }

    private void shareApp() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage = "\nLet me recommend you this application\n\n";
//                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }


    @Override
    public void onItemClick(int position, List<Result> dataset, Context context) {
    }

    @Override
    public void onshareItemClick(int position) {
        shareApp();
    }

}
