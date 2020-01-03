package com.example.multipleapicall.viewholder;


import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.databinding.ItemTitlelayoutBinding;
import com.example.multipleapicall.modelclass.Result;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ItemTitlelayoutBinding titlebinding;

    public MovieViewHolder(ItemTitlelayoutBinding titlebinding) {
        super(titlebinding.getRoot());
        this.titlebinding = titlebinding;

    }
    public ItemTitlelayoutBinding getTitleBinding() {

        return titlebinding;
    }

    public void titlebind(Result titleresult) {
        titlebinding.setTitle(titleresult);
        titlebinding.executePendingBindings();
    }
}
