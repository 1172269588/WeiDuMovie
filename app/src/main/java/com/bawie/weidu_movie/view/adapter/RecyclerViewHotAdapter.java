package com.bawie.weidu_movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.model.bean.HotMovieBean;
import com.bawie.weidu_movie.view.activity.shouye.GengDuoActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/8 09:03
 */
public class RecyclerViewHotAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HotMovieBean.ResultBean> datas = new ArrayList<>();
    public RecyclerViewHotAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_ishit_recyclerview, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_name.setText(datas.get(position).getName());
        Glide.with(context).load(datas.get(position).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.iv_imageUrl);
        viewHolder.tv_score.setText(datas.get(position).getScore()+"分");
        viewHolder.iv_imageUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,GengDuoActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<HotMovieBean.ResultBean> hotResult) {

        if (hotResult.size() > 0 && hotResult != null){
            datas.addAll(hotResult);
        }
        notifyDataSetChanged();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name;
        private final Button btn_buy_ticket;
        private final ImageView iv_imageUrl;
        private final TextView tv_score;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_imageUrl = itemView.findViewById(R.id.iv_imageUrl);
            btn_buy_ticket = itemView.findViewById(R.id.btn_buy_ticket);
            tv_score = itemView.findViewById(R.id.tv_score);
        }
    }
}
