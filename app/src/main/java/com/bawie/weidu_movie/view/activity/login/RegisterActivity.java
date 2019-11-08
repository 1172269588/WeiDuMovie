package com.bawie.weidu_movie.view.activity.login;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.model.bean.LoginBean;
import com.bawie.weidu_movie.presenter.LoginPresenter;
import com.bawie.weidu_movie.view.activity.base.BaseActivity;
import com.bawie.weidu_movie.view.interfaces.IContractView;

/**
 * 作者： 姓名
 * 日期： 2019/11/6 14:25
 */
public class RegisterActivity extends BaseActivity<LoginPresenter> implements IContractView.iMovieLogin {
    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter setPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginSuccess(LoginBean loginBean) {

    }
}
