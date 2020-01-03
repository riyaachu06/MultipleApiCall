package com.example.multipleapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.databinding.ItemverticalBinding;
import com.example.multipleapicall.modelclass.Result;
import com.example.multipleapicall.viewholder.VerticalViewHolder;

import java.util.List;

public class VerticalRecycleviewAdapter extends RecyclerView.Adapter {
    private List<Result> dataset;
    Context context;

    public VerticalRecycleviewAdapter(Context context, List<Result> dataset) {
        this.dataset = dataset;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemverticalBinding itemverticalBinding = ItemverticalBinding.inflate(inflater, parent, false);
        return new VerticalViewHolder(itemverticalBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VerticalViewHolder verticalViewHolder;
        if (holder instanceof VerticalViewHolder) {
            verticalViewHolder = (VerticalViewHolder) holder;
            setVerticalrViewHolder(verticalViewHolder, position);
        }
    }

    private void setVerticalrViewHolder(VerticalViewHolder verticalViewHolder, int position) {
        Result titlemovie = dataset.get(position);
        verticalViewHolder.bind(titlemovie);
        verticalViewHolder.setItemListDataAdapter(dataset, context);
    }
    @Override
    public int getItemCount() {
        return 1;
    }

}
