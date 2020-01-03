package com.example.multipleapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.Utility;
import com.example.multipleapicall.databinding.BlankLayoutBinding;
import com.example.multipleapicall.databinding.ItemTitlelayoutBinding;
import com.example.multipleapicall.modelclass.Result;
import com.example.multipleapicall.viewholder.BlankViewHolder;
import com.example.multipleapicall.viewholder.MovieViewHolder;


import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter {
    private List<Result> dataset;
    Context context;


    public TitleAdapter(Context context, List<Result> dataset) {
        this.context = context;
        this.dataset = dataset;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == 1) {
            ItemTitlelayoutBinding titlebinding = ItemTitlelayoutBinding.inflate(inflater, parent, false);
            return new MovieViewHolder(titlebinding);
        } else if (viewType == 2) {
            ItemTitlelayoutBinding titlebinding = ItemTitlelayoutBinding.inflate(inflater, parent, false);
            return new MovieViewHolder(titlebinding);
        } else {
            BlankLayoutBinding blankLayoutBinding = BlankLayoutBinding.inflate(inflater, parent, false);
            return new BlankViewHolder(blankLayoutBinding);
        }

    }

    @Override
    public int getItemViewType(int position) {

        Result item = dataset.get(position);
        if (item.getMOVIERESULT()) {
            return 1;
        } else if (item.getPOPULARMOVIERESULT()) {
            return 2;
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieViewHolder movieViewHolder;
        Result item = dataset.get(position);
        if (item.getMOVIERESULT()) {
            if (holder instanceof MovieViewHolder) {
                movieViewHolder = (MovieViewHolder) holder;
                settitleuserviewholder(movieViewHolder, position);
            }
        }
        if (item.getPOPULARMOVIERESULT()) {
            if (holder instanceof MovieViewHolder) {
                movieViewHolder = (MovieViewHolder) holder;
                settitleuserviewholder(movieViewHolder, position);
            }
        }
    }

    private void settitleuserviewholder(MovieViewHolder movieViewHolder, int position) {
        Result titlemovie = dataset.get(position).getSingleMovieResult();
        String imageicon = titlemovie.getPosterPath();
        String IMAGE_URL = "https://image.tmdb.org/t/p/w200/" + imageicon;
        if (titlemovie != null) {
            movieViewHolder.titlebind(titlemovie);
            Utility.loadImageUsingGlide(context, movieViewHolder.getTitleBinding().imageView, IMAGE_URL);
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


}
