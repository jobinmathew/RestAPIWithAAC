package com.jobin.restapiwithaac.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jobin.restapiwithaac.R;
import com.jobin.restapiwithaac.database.AlbumContentModel;

import java.util.List;

/**
 * Class RecyclerViewAdapter
 * Description :
 * Created by Jobin Mathew on 08:08 28-11-2018.
 * All rights reserved @ hashincludes.com
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<AlbumContentModel> albumContentModelList;
    private Context context;
    public RecyclerViewAdapter(List<AlbumContentModel> albumContentModelList, Context context) {
        this.albumContentModelList = albumContentModelList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        AlbumContentModel albumContentModel = albumContentModelList.get(position);
        holder.albumLabelTextView.setText(albumContentModel.getTitle());
        holder.itemView.setTag(albumContentModel);
    }

    @Override
    public int getItemCount() {
        return albumContentModelList.size();
    }

    public void addItems(List<AlbumContentModel> albumContentModelList) {
        this.albumContentModelList = albumContentModelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView albumLabelTextView;
        RecyclerViewHolder(View view) {
            super(view);
            albumLabelTextView = view.findViewById(R.id.album_name_textView);
        }
    }
}