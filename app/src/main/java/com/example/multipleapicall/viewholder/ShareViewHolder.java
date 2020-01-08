package com.example.multipleapicall.viewholder;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.databinding.SharelayoutBinding;
import com.example.multipleapicall.interfaces.OnItemClickListener;

public class ShareViewHolder extends RecyclerView.ViewHolder {
    SharelayoutBinding sharelayoutBinding;
    private OnItemClickListener mListener;

    public ShareViewHolder(SharelayoutBinding sharelayoutBinding, final OnItemClickListener mListener) {
        super(sharelayoutBinding.getRoot());
        this.sharelayoutBinding = sharelayoutBinding;
        this.mListener = mListener;

        sharelayoutBinding.shareappid.setOnClickListener(new View.OnClickListener() { // we can handle the click as like we do in normal
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    mListener.onshareItemClick(position);
                }
            }
        });

    }
    public SharelayoutBinding getBlankLayoutBinding() {
        return sharelayoutBinding;
    }
}
