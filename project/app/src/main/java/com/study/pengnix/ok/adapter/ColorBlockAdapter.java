package com.study.pengnix.ok.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.study.pengnix.ok.R;
import com.study.pengnix.ok.bean.ColorBlock;

import java.util.List;

public class ColorBlockAdapter extends RecyclerView.Adapter<ColorBlockAdapter.ViewHolder> {

    private List<ColorBlock> mColorBlockList;

    public ColorBlockAdapter(List<ColorBlock> mColorBlockList) {
        this.mColorBlockList = mColorBlockList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView colorBlock;

        public ViewHolder (View view)
        {
            super(view);
            colorBlock = (TextView) view.findViewById(R.id.tv_color_block);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_color_block, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ColorBlock colorBlock = mColorBlockList.get(position);
        holder.colorBlock.setText(colorBlock.getName());
    }

    @Override
    public int getItemCount() {
        return mColorBlockList.size();
    }
}
