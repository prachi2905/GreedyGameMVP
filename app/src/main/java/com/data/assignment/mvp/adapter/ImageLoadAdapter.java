package com.data.assignment.mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.data.assignment.AppConstatnt.AppConstant;
import com.data.assignment.Model.Children;
import com.data.assignment.R;
import com.data.assignment.databinding.ImageUploadUiBinding;
import com.data.assignment.mvp.ui.ImageDetailsActivity;

import com.data.imageloaderlib.ImageLoader;

import java.util.List;


public class ImageLoadAdapter extends RecyclerView.Adapter<ImageLoadAdapter.ViewHolder> {

    private Context mContext;
    private List<Children> dataList;


    public ImageLoadAdapter(Context mContext, List<Children> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageUploadUiBinding imageUploadUiBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.image_upload_ui, parent, false);
        return new ViewHolder(imageUploadUiBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ImageLoader.Companion.with(mContext).load(holder.imageUploadUiBinding.imageView, dataList.get(position).getData().getPreview().getImages().get(0).getSource().getUrl());
        holder.imageUploadUiBinding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ImageDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(AppConstant.IMAGE_VIEW,dataList.get(position).getData().getPreview().getImages().get(0).getSource().getUrl());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        ImageUploadUiBinding imageUploadUiBinding;


        ViewHolder(ImageUploadUiBinding imageUploadUiBinding) {
            super(imageUploadUiBinding.getRoot());
            this.imageUploadUiBinding = imageUploadUiBinding;
        }
    }

}
