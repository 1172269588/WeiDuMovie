package com.bawie.weidu_movie.view.fragment.gengduoFragment;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.model.core.DataCall;
import com.bawie.weidu_movie.model.wangben.Bean;
import com.bawie.weidu_movie.model.wangben.YingXiang;
import com.bawie.weidu_movie.presenter.wangpresenter.XiangQing1Presenter;
import com.bawie.weidu_movie.view.adapter.wangadapter.Xiang1Adapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Xiang1Fragment extends Fragment {
    private XiangQing1Presenter xiangQing1Presenter;
    private RecyclerView recy_view;
    private Xiang1Adapter xiang1Adapter;


    private View inflate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_xiang1, container, false);
        xiangQing1Presenter = new XiangQing1Presenter(new MyCall());
        recy_view = inflate.findViewById(R.id.recy_view);
        xiangQing1Presenter.getData("1","5");
        xiang1Adapter = new Xiang1Adapter(getContext());
        recy_view.setAdapter(xiang1Adapter);
        recy_view.setLayoutManager(new LinearLayoutManager(getContext()));

        return inflate;
    }

    class MyCall implements DataCall<List<YingXiang>> {


        @Override
        public void Seccess(List<YingXiang> yingXiangs) {
            xiang1Adapter.addAll(yingXiangs);
        }

        @Override
        public void Fails(Bean b) {

        }
    }


}