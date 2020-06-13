package com.data.assignment.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.data.assignment.Model.Children;
import com.data.assignment.R;
import com.data.assignment.databinding.ImageUploadUiBinding;

import java.util.List;


public class ImageLoadAdapter extends RecyclerView.Adapter<ImageLoadAdapter.ViewHolder> {

    private Context context;
    private List<Children> dataList;


    public ImageLoadAdapter(Context context, List<Children> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void update(List<Children> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageUploadUiBinding imageUploadUiBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.image_upload_ui, parent, false);
        return new ViewHolder(imageUploadUiBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
