package com.bawie.weidu_movie.view.fragment.yingyuanfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.model.core.DataCall;
import com.bawie.weidu_movie.model.wangben.Bean;
import com.bawie.weidu_movie.model.wangben.YingYuan;
import com.bawie.weidu_movie.presenter.wangpresenter.FuYingYuanPresenter;
import com.bawie.weidu_movie.presenter.wangpresenter.TuiYingYuanPresenter;
import com.bawie.weidu_movie.view.adapter.wangadapter.YingYuanAdapter;

import java.util.List;

public class Fragment_Fu extends Fragment {
    private RecyclerView recy_view;
    private View inflate;
    private YingYuanAdapter yingYuanAdapter;
    private FuYingYuanPresenter fuYingYuanPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_fragment__fu, container, false);
        //recy_view = inflate.findViewById(R.id.recy_view);
        //fuYingYuanPresenter = new FuYingYuanPresenter(new MyCall());
        //yingYuanAdapter = new YingYuanAdapter(getActivity());
        //recy_view.setAdapter(yingYuanAdapter);
        //recy_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        //fuYingYuanPresenter.getData("1","5");


        return inflate;
    }
    class MyCall implements DataCall<List<YingYuan>>{

        @Override
        public void Seccess(List<YingYuan> yingYuans) {
            yingYuanAdapter.addAll(yingYuans);
        }

        @Override
        public void Fails(Bean b) {

        }
    }
}
