package com.example.multipleapicall.viewholder;


import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.databinding.ItemTitlelayoutBinding;
import com.example.multipleapicall.interfaces.OnItemClickListener;
import com.example.multipleapicall.modelclass.Result;

import java.util.List;


public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ItemTitlelayoutBinding titlebinding;
    private OnItemClickListener mListener;
    private List<Result> dataset;
    private Context context;

    public MovieViewHolder(final Context context, ItemTitlelayoutBinding titlebinding, OnItemClickListener listener, final List<Result> dataset) {
        super(titlebinding.getRoot());
        this.titlebinding = titlebinding;
        this.mListener = listener;
        this.dataset = dataset;
        this.context = context;


        titlebinding.cardview.setOnClickListener(new View.OnClickListener() { // we can handle the click as like we do in normal
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                        mListener.onItemClick(position, dataset, context);
                }
            }
        });
    }

    public ItemTitlelayoutBinding getTitleBinding() {

        return titlebinding;
    }

    public void titlebind(Result titleresult) {
        titlebinding.setTitle(titleresult);
        titlebinding.executePendingBindings();
    }
}
