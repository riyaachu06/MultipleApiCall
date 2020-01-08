package com.example.multipleapicall.viewholder;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.activity.MovieDetailsActvity;
import com.example.multipleapicall.adapter.TitleAdapter;
import com.example.multipleapicall.databinding.ItemverticalBinding;
import com.example.multipleapicall.interfaces.OnItemClickListener;
import com.example.multipleapicall.modelclass.Result;

import java.util.List;

public class VerticalViewHolder extends RecyclerView.ViewHolder implements OnItemClickListener {
    private ItemverticalBinding itemverticalBinding;
    TitleAdapter itemListDataAdapter;
    public static final String ITEM = "item";

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
        itemListDataAdapter = new TitleAdapter(context, dataset);
        itemverticalBinding.recycleviewHorizontal.setHasFixedSize(true);
        itemverticalBinding.recycleviewHorizontal.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        itemListDataAdapter.setOnItemClickListener(this);
        itemverticalBinding.recycleviewHorizontal.setAdapter(itemListDataAdapter);
    }

    @Override
    public void onItemClick(int position, List<Result> dataset, Context context) {
        Intent intent = new Intent(context, MovieDetailsActvity.class);
        intent.putExtra(ITEM, dataset.get(position));
        context.startActivity(intent);
    }

    @Override
    public void onshareItemClick(int position) {
    }
}
