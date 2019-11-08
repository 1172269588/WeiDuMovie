package com.bawie.weidu_movie.view.adapter;

import android.content.Context;
import android.text.format.DateUtils;
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
import com.bawie.weidu_movie.model.bean.UpComingBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 姓名
 * 日期： 2019/11/8 09:03
 */
public class RecyclerUpComingAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<UpComingBean.ResultBean> datas = new ArrayList<>();
    public RecyclerUpComingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_upcoming_recyclerview, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv_name.setText(datas.get(position).getName());
        Glide.with(context).load(datas.get(position).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(myViewHolder.iv_imageUrl);
        myViewHolder.tv_wantSeeNum.setText(datas.get(position).getWantSeeNum()+"人想看");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(List<UpComingBean.ResultBean> upComingBeanResult) {
        if (upComingBeanResult.size()>0 && upComingBeanResult != null){
            datas.addAll(upComingBeanResult);
        }
        notifyDataSetChanged();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
        void appointmentClick(int movieId);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_releaseTime;
        private final TextView tv_wantSeeNum;
        private final ImageView iv_imageUrl;
        private final Button btn_appointment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_releaseTime = itemView.findViewById(R.id.tv_releaseTime);
            tv_wantSeeNum = itemView.findViewById(R.id.tv_wantSeeNum);
            iv_imageUrl = itemView.findViewById(R.id.iv_imageUrl);
            btn_appointment = itemView.findViewById(R.id.btn_appointment);
        }
    }
}


