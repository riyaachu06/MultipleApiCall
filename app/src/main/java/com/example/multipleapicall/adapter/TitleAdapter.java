package com.example.multipleapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.Utility;
import com.example.multipleapicall.databinding.ItemTitlelayoutBinding;
import com.example.multipleapicall.interfaces.OnItemClickListener;
import com.example.multipleapicall.modelclass.Result;
import com.example.multipleapicall.viewholder.MovieViewHolder;

import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter {
    private List<Result> dataset;
    Context context;
    private OnItemClickListener mListener;
    ItemTitlelayoutBinding titlebinding;

    public TitleAdapter(Context context, List<Result> dataset) {
        this.dataset = dataset;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        titlebinding = ItemTitlelayoutBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(context, titlebinding, mListener, dataset);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieViewHolder movieViewHolder;

        if (holder instanceof MovieViewHolder) {
            movieViewHolder = (MovieViewHolder) holder;
            settitleuserviewholder(movieViewHolder, position);
        }
    }

    private void settitleuserviewholder(MovieViewHolder movieViewHolder, int position) {
        Result titlemovie = dataset.get(position);
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

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

}
