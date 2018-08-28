package com.dmko.devtask.ui.screens.images.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmko.devtask.R;

import java.util.Collections;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private List<String> images;

    public ImagesAdapter() {
        this.images = Collections.emptyList();
    }

    public void setImages(List<String> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_image, viewGroup, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        String imageUrl = images.get(i);
        imageViewHolder.bindImage(imageUrl);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
