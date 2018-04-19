package com.thanar.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by thanar on 4/19/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ItemClickListener mItemClickListener;
    private List<People> mData = Collections.emptyList();
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context, List<People> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        People you = mData.get(position);
        holder.tvName.setText(you.getSurname());
        holder.ivResId.setBackgroundResource(you.getResId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public People getItem(int id) {
        return mData.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView tvName;
        protected ImageView ivResId;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            ivResId = (ImageView) itemView.findViewById(R.id.ivResId);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null )
                mItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }

}


