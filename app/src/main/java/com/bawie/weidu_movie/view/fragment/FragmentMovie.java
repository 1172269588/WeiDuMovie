package com.bawie.weidu_movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.model.bean.HotMovieBean;
import com.bawie.weidu_movie.model.bean.IsHotMovieBean;
import com.bawie.weidu_movie.model.bean.MovieFragBannerBean;
import com.bawie.weidu_movie.model.bean.ReserveBean;
import com.bawie.weidu_movie.model.bean.UpComingBean;
import com.bawie.weidu_movie.presenter.MovieHomePresenter;
import com.bawie.weidu_movie.view.activity.login.MovieActivity;
import com.bawie.weidu_movie.view.adapter.RecyclerUpComingAdapter;
import com.bawie.weidu_movie.view.adapter.RecyclerViewHotAdapter;
import com.bawie.weidu_movie.view.adapter.RecyclerViewIsHotAdapter;
import com.bawie.weidu_movie.view.interfaces.IBaseView;
import com.bawie.weidu_movie.view.interfaces.IContractView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者： 姓名
 * 日期： 2019/11/7 10:30
 */
public class FragmentMovie extends Fragment implements IContractView.iMovieView, IBaseView {

    @BindView(R.id.img_location)
    ImageButton imgLocation;
    @BindView(R.id.img_search)
    ImageButton imgSearch;
    @BindView(R.id.banner)
    XBanner banner;
    @BindView(R.id.frag_movie_page)
    TextView fragMoviePage;
    @BindView(R.id.tv_movie_more1)
    TextView tvMovieMore1;

    @BindView(R.id.tv_movie_more2)
    TextView tvMovieMore2;

    @BindView(R.id.tv_movie_more3)
    TextView tvMovieMore3;
    @BindView(R.id.btn_buy_ticket)
    Button btnBuyTicket;
    @BindView(R.id.iv_imageUrl)
    ImageView ivImageUrl;
    @BindView(R.id.recycler_isHit)
    RecyclerView recyclerIsHit;
    @BindView(R.id.recycler_upComing)
    RecyclerView recyclerUpComing;
    @BindView(R.id.recycler_hot)
    RecyclerView recyclerHot;
    private int page = 1;
    private int count = 14;
    private Unbinder unbinder;
    private MovieHomePresenter homePresenter;
    private List<IsHotMovieBean.ResultBean> isHotResult;
    private RecyclerViewIsHotAdapter recyclerViewIsHotAdapter;
    private List<UpComingBean.ResultBean> upComingBeanResult;
    private RecyclerUpComingAdapter recyclerUpComingAdapter;
    private List<HotMovieBean.ResultBean> hotResult;
    private RecyclerViewHotAdapter recyclerViewHotAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_movie, null);
        unbinder = ButterKnife.bind(this, inflate);
        homePresenter = new MovieHomePresenter();
        homePresenter.attachView(this);
        //首页Banner
        homePresenter.movieBenner();
        //正在热映
        homePresenter.IsHotMovie(page, count);
        //即将上映
        homePresenter.upComingMovie(page, count);
        //热门电影
        homePresenter.hotMovie(page, count);
        return inflate;

    }
    //banner
    @Override
    public void movieBanner(MovieFragBannerBean movieFragBannerBean) {
        List<MovieFragBannerBean.ResultBean> images = movieFragBannerBean.getResult();
        Log.e("hhhhhhhh", images.get(0).getImageUrl());
        banner.setData(images,null);
        banner.setPageChangeDuration(2000);
        banner.setPageTransformer(Transformer.Default);
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(images.get(position).getImageUrl()).into((ImageView) view);
                fragMoviePage.setText(images.get(position).getRank()+"/5");
            }
        });
        banner.startAutoPlay();
    }
    //正在热映
    @Override
    public void IsHotSuccess(IsHotMovieBean isHotMovieBean) {
        isHotResult = isHotMovieBean.getResult() ;
        recyclerViewIsHotAdapter = new RecyclerViewIsHotAdapter(getActivity());

        recyclerViewIsHotAdapter.addData(isHotResult);
        recyclerIsHit.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerIsHit.setAdapter(recyclerViewIsHotAdapter);

        recyclerViewIsHotAdapter.onItemClickListener(new RecyclerViewIsHotAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int movieId = isHotResult.get(position).getMovieId();
                Intent intent = new Intent(getActivity(), MovieActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });
    }
    //即将上映
    @Override
    public void upComingSuccess(UpComingBean upComingBean) {
        upComingBeanResult = upComingBean.getResult();
        recyclerUpComingAdapter = new RecyclerUpComingAdapter(getActivity());
        recyclerUpComingAdapter.addData(upComingBeanResult);
        recyclerUpComing.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerUpComing.setAdapter(recyclerUpComingAdapter);
        recyclerUpComingAdapter.onItemClickListener(new RecyclerUpComingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void appointmentClick(int movieId) {

            }
        });
    }
    //热门电影
    @Override
    public void hotSuccess(HotMovieBean hotMovieBean) {
        hotResult = hotMovieBean.getResult();
        recyclerViewHotAdapter = new RecyclerViewHotAdapter(getActivity());
        recyclerViewHotAdapter.addData(hotResult);
        recyclerHot.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerHot.setAdapter(recyclerViewHotAdapter);

        Glide.with(getActivity()).load(hotResult.get(1).getHorizontalImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(ivImageUrl);
    }

    @Override
    public void reserveSuccess(ReserveBean reserveBean) {

    }

    @OnClick({R.id.img_location, R.id.img_search, R.id.tv_movie_more1, R.id.tv_movie_more2, R.id.tv_movie_more3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_location:
                break;
            case R.id.img_search:
                break;
            case R.id.tv_movie_more1:
                break;
            case R.id.tv_movie_more2:
                break;
            case R.id.tv_movie_more3:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        homePresenter.detachView();
    }
}
