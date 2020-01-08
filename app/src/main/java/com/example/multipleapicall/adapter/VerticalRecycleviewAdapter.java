package com.example.multipleapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multipleapicall.databinding.BlankLayoutBinding;
import com.example.multipleapicall.databinding.ItemverticalBinding;
import com.example.multipleapicall.databinding.MylocationLayoutBinding;
import com.example.multipleapicall.databinding.SharelayoutBinding;
import com.example.multipleapicall.interfaces.OnItemClickListener;
import com.example.multipleapicall.modelclass.Result;
import com.example.multipleapicall.viewholder.BlankViewHolder;
import com.example.multipleapicall.viewholder.LocationViewHolder;
import com.example.multipleapicall.viewholder.ShareViewHolder;
import com.example.multipleapicall.viewholder.VerticalViewHolder;

import java.util.List;

public class VerticalRecycleviewAdapter extends RecyclerView.Adapter {
    private List<Result> dataset;
    Context context;
    ItemverticalBinding itemverticalBinding;
    SharelayoutBinding sharelayoutBinding;
    BlankLayoutBinding blankLayoutBinding;
    MylocationLayoutBinding mylocationLayoutBinding;
    private OnItemClickListener mListener;


    public VerticalRecycleviewAdapter(Context context, List<Result> dataset) {
        this.dataset = dataset;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            itemverticalBinding = ItemverticalBinding.inflate(inflater, parent, false);
            return new VerticalViewHolder(itemverticalBinding);
        }
        else if (viewType == 2) {
            mylocationLayoutBinding = MylocationLayoutBinding.inflate(inflater, parent, false);
            return new LocationViewHolder(mylocationLayoutBinding);
        }
        else if (viewType == 3) {
            sharelayoutBinding = SharelayoutBinding.inflate(inflater, parent, false);
            return new ShareViewHolder(sharelayoutBinding, mListener);
        }
        else
            blankLayoutBinding = BlankLayoutBinding.inflate(inflater, parent, false);
        return new BlankViewHolder(blankLayoutBinding);

    }

    @Override
    public int getItemViewType(int position) {
        Result item = dataset.get(position);
         if (item.getPopularMovieSet()||item.getAllMovieSet()) {
            return 1;
        }
         else if (item.getLocation()) {
             return 2;
         }
        else if (item.getShareApp()) {
             return 3;
         }
        return super.getItemViewType(position);
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
        if (dataset.size() > position) {
            Result titlemovie = dataset.get(position);
            if (titlemovie.getAllMovieSet()) {
                itemverticalBinding.textViewhead.setText("Top Videos");
            }
            if (titlemovie.getPopularMovieSet()) {
                itemverticalBinding.textViewhead.setText("Popular Videos");
            }
            verticalViewHolder.bind(titlemovie);
            verticalViewHolder.setItemListDataAdapter(dataset.get(position).getMovieSet(), context);
        }
    }
    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}
