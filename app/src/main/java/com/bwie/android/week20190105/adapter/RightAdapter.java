package com.bwie.android.week20190105.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.android.week20190105.R;
import com.bwie.android.week20190105.bean.RightBean;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {
    private Context context;
    private List<RightBean.DatasBean> list;

    public RightAdapter(Context context, List<RightBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_fragment_layout, parent, false);
        RightViewHolder holder = new RightViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {
        RightBean.DatasBean dataBean = list.get(position);
        List<RightBean.DatasBean.ChildData> childList = dataBean.list;
        String name = dataBean.name;
        holder.tv_title.setText(name);
//        设置子列表适配器
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        holder.recyclerView.setAdapter(new RightChildAdapter(context,childList));

    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private RecyclerView recyclerView;

        public RightViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.title_right);
            recyclerView = itemView.findViewById(R.id.rv_rightRv);
        }
    }


}
