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
import com.bawie.weidu_movie.presenter.wangpresenter.TuiYingYuanPresenter;
import com.bawie.weidu_movie.view.adapter.wangadapter.YingYuanAdapter;

import java.util.List;

public class Fragment_Tui extends Fragment {
    private RecyclerView recy_view;
    private View inflate;
    private TuiYingYuanPresenter tuiYingYuanPresenter;
    private YingYuanAdapter yingYuanAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment__tui, container, false);
        recy_view = inflate.findViewById(R.id.recy_view);
        tuiYingYuanPresenter = new TuiYingYuanPresenter(new MyCall());
        yingYuanAdapter = new YingYuanAdapter(getActivity());
        recy_view.setAdapter(yingYuanAdapter);
        recy_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        tuiYingYuanPresenter.getData("1","5");

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
