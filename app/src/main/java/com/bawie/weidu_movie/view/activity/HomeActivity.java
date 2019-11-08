package com.bawie.weidu_movie.view.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.presenter.HomeFragPresenter;
import com.bawie.weidu_movie.view.activity.base.BaseActivity;
import com.bawie.weidu_movie.view.adapter.HomePageFragmentAdapter;
import com.bawie.weidu_movie.view.fragment.FragmentCinema;
import com.bawie.weidu_movie.view.fragment.FragmentMovie;
import com.bawie.weidu_movie.view.fragment.FragmentMy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/6 14:13
 */
public class HomeActivity extends BaseActivity<HomeFragPresenter> {
    @BindView(R.id.vp_main_viewPager)
    ViewPager vpMainViewPager;
    @BindView(R.id.rb_main_movie)
    RadioButton rbMainMovie;
    @BindView(R.id.rb_main_cinema)
    RadioButton rbMainCinema;
    @BindView(R.id.rb_main_my)
    RadioButton rbMainMy;
    @BindView(R.id.rg_main_radioGroup)
    RadioGroup rgMainRadioGroup;
    Bitmap b = null;

    private Unbinder bind;
    private List<Fragment> fragments;
    private HomePageFragmentAdapter homePageFragmentAdapter;
    @Override
    protected int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected HomeFragPresenter setPresenter() {
        return new HomeFragPresenter();
    }

    @Override
    protected void initData() {
        rbMainMovie.setButtonDrawable(new BitmapDrawable(b));
        rbMainCinema.setButtonDrawable(new BitmapDrawable(b));
        rbMainMy.setButtonDrawable(new BitmapDrawable(b));
        fragments = new ArrayList<>();
        fragments.add(new FragmentMovie());
        fragments.add(new FragmentCinema());
        fragments.add(new FragmentMy());
        homePageFragmentAdapter = new HomePageFragmentAdapter(getSupportFragmentManager(), fragments);
        vpMainViewPager.setAdapter(homePageFragmentAdapter);
        vpMainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        rgMainRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_main_movie:
                        vpMainViewPager.setCurrentItem(0);
                        break;

                    case R.id.rb_main_cinema:
                        vpMainViewPager.setCurrentItem(1);
                        break;

                    case R.id.rb_main_my:
                        vpMainViewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
