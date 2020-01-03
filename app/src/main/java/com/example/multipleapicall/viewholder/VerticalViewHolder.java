package com.example.multipleapicall.viewholder;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.adapter.TitleAdapter;
import com.example.multipleapicall.databinding.ItemverticalBinding;
import com.example.multipleapicall.modelclass.Result;

import java.util.List;

public class VerticalViewHolder extends RecyclerView.ViewHolder {
    private ItemverticalBinding itemverticalBinding;

    public VerticalViewHolder(ItemverticalBinding itemverticalBinding) {
        super(itemverticalBinding.getRoot());
        this.itemverticalBinding = itemverticalBinding;
    }

    public ItemverticalBinding getBinding() {

        return itemverticalBinding;
    }

    public void bind(Result details) {
        itemverticalBinding.setDetails(details);
        itemverticalBinding.executePendingBindings();//is important in order to execute the data binding immediately. Otherwise it can populate incorrect view.
    }

    public void setItemListDataAdapter(List<Result> dataset, Context context) {
        TitleAdapter itemListDataAdapter = new TitleAdapter(context, dataset);
        itemverticalBinding.recycleviewHorizontal.setHasFixedSize(true);
        itemverticalBinding.recycleviewHorizontal.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        itemverticalBinding.recycleviewHorizontal.setAdapter(itemListDataAdapter);
    }


}
