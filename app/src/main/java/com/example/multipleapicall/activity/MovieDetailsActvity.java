package com.example.multipleapicall.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.multipleapicall.R;
import com.example.multipleapicall.databinding.ActivityMoviedetailsBinding;
import com.example.multipleapicall.modelclass.Result;

import static com.example.multipleapicall.activity.VerticalActivity.ITEM;


public class MovieDetailsActvity extends AppCompatActivity {
    ActivityMoviedetailsBinding activityMoviedetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMoviedetailsBinding= DataBindingUtil.setContentView(this, R.layout.activity_moviedetails);
        getMovieDetails();
    }
    private void getMovieDetails() {
        Intent intent = getIntent();
        Result clickedItem = intent.getParcelableExtra(ITEM);
        activityMoviedetailsBinding.setDetails(clickedItem);
        activityMoviedetailsBinding.include.ratingBar.setRating(Float.parseFloat(Double.toString(clickedItem.getVoteAverage())));
    }
}
