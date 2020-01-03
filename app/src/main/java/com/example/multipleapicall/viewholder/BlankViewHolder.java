package com.example.multipleapicall.viewholder;

import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.databinding.BlankLayoutBinding;


public class BlankViewHolder extends RecyclerView.ViewHolder {
    BlankLayoutBinding blankLayoutBinding;

    public BlankViewHolder(BlankLayoutBinding blankLayoutBinding) {
        super(blankLayoutBinding.getRoot());
        this.blankLayoutBinding = blankLayoutBinding;
    }
    public BlankLayoutBinding getBlankLayoutBinding() {
        return blankLayoutBinding;
    }


}
