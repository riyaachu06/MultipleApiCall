package com.example.multipleapicall.interfaces;

import android.content.Context;

import com.example.multipleapicall.modelclass.Result;

import java.util.List;

public interface OnItemClickListener  {

    void onItemClick(int position, List<Result> dataset, Context context);
    void onshareItemClick(int position);


}
