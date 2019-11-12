package com.bawie.weidu_movie.view.adapter.wangadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.model.wangben.YingYuan;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:王帅
 * 时间:2019/11/12
 * 功能:
 */
public class YingYuanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<YingYuan> list;
    private Context context;
    private View inflate;

    public YingYuanAdapter(Context context) {
        this.list = new ArrayList<>();
        this.context = context;
    }
    public void addAll(List<YingYuan> data){
        if (data!=null){
            list.addAll(data);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(context).inflate(R.layout.item_tuiyingyuan, parent, false);

        return new TuiYingYuanViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TuiYingYuanViewHolder tui;
        tui = new TuiYingYuanViewHolder(inflate);
        tui.tv_name.setText(list.get(position).name);
        tui.tv_address.setText(list.get(position).address);
        Glide.with(context).load(list.get(position).logo).into(tui.iv_logo);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class TuiYingYuanViewHolder extends RecyclerView.ViewHolder{


        private final ImageView iv_logo;
        private final TextView tv_name;
        private final TextView tv_address;

        public TuiYingYuanViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_logo = itemView.findViewById(R.id.iv_logo);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
        }
    }
}
