package com.bawie.weidu_movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.model.bean.CinemaDetailsBean;
import com.bawie.weidu_movie.model.bean.UserBean;
import com.bawie.weidu_movie.presenter.CinemaDetailsPresenter;
import com.bawie.weidu_movie.view.activity.base.BaseActivity;
import com.bawie.weidu_movie.view.adapter.CinemaFragmentAdapter;
import com.bawie.weidu_movie.view.fragment.CinemaDetailsFragment;
import com.bawie.weidu_movie.view.fragment.CinemaEvaluationFragment;
import com.bawie.weidu_movie.view.interfaces.IContractView;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class YingYuanXiangQIngActivity extends BaseActivity<CinemaDetailsPresenter> implements IContractView.ICinemaDetailsView {

    @BindView(R.id.tv_cinemaName)
    TextView tvCinemaName;
    @BindView(R.id.tv_lable)
    TextView tv_lable;
    @BindView(R.id.tab_layout_cinema_details)
    TabLayout tabLayoutCinemaDetails;
    @BindView(R.id.view_pager_cinema_details)
    ViewPager viewPagerCinemaDetails;
    private String sessionId;
    private int userId;
    private Unbinder bind;
    private List<Fragment> fragments;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int cinemaId = intent.getIntExtra("cinemaId", 0);
        presenter.cinemaInfo(userId, sessionId, cinemaId);
        fragments = new ArrayList<>();
        fragments.add(new CinemaDetailsFragment());
        fragments.add(new CinemaEvaluationFragment());
        CinemaFragmentAdapter cinemaFragmentAdapter = new CinemaFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPagerCinemaDetails.setAdapter(cinemaFragmentAdapter);

        for (int i = 0; i < fragments.size(); i++) {
            tabLayoutCinemaDetails.addTab(tabLayoutCinemaDetails.newTab());
        }

        tabLayoutCinemaDetails.setupWithViewPager(viewPagerCinemaDetails);

        tabLayoutCinemaDetails.getTabAt(0).setText("影院详情");
        tabLayoutCinemaDetails.getTabAt(1).setText("影院评价");
    }

    @Override
    protected CinemaDetailsPresenter setPresenter() {
        return new CinemaDetailsPresenter();
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        bind = ButterKnife.bind(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_ying_yuan_xiang_qing;
    }

    @Override
    public void cinemaDetailsSuccess(CinemaDetailsBean cinemaDetailsBean) {
        Log.e("MyMessageCinema", cinemaDetailsBean.getResult().getName());
        CinemaDetailsBean.ResultBean result = cinemaDetailsBean.getResult();
        String label = cinemaDetailsBean.getResult().getLabel();
        tv_lable.setText(label);
        tvCinemaName.setText(result.getName()+"("+result.getAddress()+")");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Message(UserBean userBean) {
        userId = userBean.getUserId();
        sessionId = userBean.getSessionId();
    }

    @Override
    public void cinemaDetailsError(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        bind.unbind();
    }
}
