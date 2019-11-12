package com.bawie.weidu_movie.presenter;

import com.bawie.weidu_movie.model.bean.SearchBean;
import com.bawie.weidu_movie.model.http.OkHttpUtils;
import com.bawie.weidu_movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/12 14:49
 */
public class SearchPresenter extends BasePresenter<IContractView.iMovieSearch> {

    public void movieSearch(String keyword, int page, int count) {
        OkHttpUtils.getInstance().search(new OkHttpUtils.IOkCallBack<SearchBean>() {
            @Override
            public void callSuccess(SearchBean bean) {
                getView().searchSuccess(bean);
            }

            @Override
            public void callError(String msg) {

            }
        },SearchBean.class,keyword,page,count);
    }
}
