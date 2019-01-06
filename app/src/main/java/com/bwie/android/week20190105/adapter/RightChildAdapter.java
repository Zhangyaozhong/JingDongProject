package com.bwie.android.week20190105.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.android.week20190105.R;
import com.bwie.android.week20190105.bean.RightBean;

import java.util.List;

public class RightChildAdapter extends RecyclerView.Adapter<RightChildAdapter.RightChildViewHolder> {
    private Context context;
    private List<RightBean.DatasBean.ChildData> list;

    public RightChildAdapter(Context context, List<RightBean.DatasBean.ChildData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RightChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_child_layout, parent, false);
        RightChildViewHolder holder = new RightChildViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RightChildViewHolder holder, int position) {
        RightBean.DatasBean.ChildData dataBean = list.get(position);
        String icon = dataBean.icon;
        String name = dataBean.name;
        Glide.with(context)
                .load(icon)
                .into(holder.iv_child);
        holder.tv_title.setText(name);


    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class RightChildViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private ImageView iv_child;

        public RightChildViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.name_child);
            iv_child = itemView.findViewById(R.id.iv_child);
        }
    }


}
