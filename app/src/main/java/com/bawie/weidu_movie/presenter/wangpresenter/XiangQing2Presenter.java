package com.bawie.weidu_movie.presenter.wangpresenter;

import com.bawie.weidu_movie.model.core.DataCall;
import com.bawie.weidu_movie.model.core.IRequest;

import io.reactivex.Observable;

/**
 * 作者:王帅
 * 时间:2019/11/11
 * 功能:
 */
public class XiangQing2Presenter extends BasePresenter{

    public XiangQing2Presenter(DataCall myCall) {
        super(myCall);
    }

    @Override
    protected Observable getModel(IRequest iRequest, Object... args) {
        return iRequest.MovieList((String)args[0],(String)args[1]);
    }
}
