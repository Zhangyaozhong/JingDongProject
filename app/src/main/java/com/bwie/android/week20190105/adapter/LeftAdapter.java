package com.bwie.android.week20190105.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.android.week20190105.R;
import com.bwie.android.week20190105.bean.LeftBean;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.LeftViewHolder> {
    private Context context;
    private List<LeftBean.DataBean> list;

    public LeftAdapter(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.left_fragment_layout, parent, false);
        LeftViewHolder holder = new LeftViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        final LeftBean.DataBean dataBean = list.get(position);
        String name = dataBean.name.toString();

        holder.tv_title.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String cid = dataBean.cid;
                itemClickListener.click(cid);
            }
        });

    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;

        public LeftViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.title_left);
        }
    }

    public interface ItemClickListener {
        void click(String cid);
    }

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
