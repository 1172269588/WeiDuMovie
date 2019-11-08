package com.bawie.weidu_movie.view.interfaces;

import com.bawie.weidu_movie.model.bean.HotMovieBean;
import com.bawie.weidu_movie.model.bean.IsHotMovieBean;
import com.bawie.weidu_movie.model.bean.LoginBean;
import com.bawie.weidu_movie.model.bean.MovieFragBannerBean;
import com.bawie.weidu_movie.model.bean.ReserveBean;
import com.bawie.weidu_movie.model.bean.UpComingBean;

/**
 * 作者： 姓名
 * 日期： 2019/11/5 15:57
 */
public interface IContractView {
    //登录
     interface iMovieLogin extends IBaseView{
         void loginSuccess(LoginBean loginBean);
     }
      //首页展示
    interface iMovieView extends IBaseView{
          void movieBanner(MovieFragBannerBean movieFragBannerBean);
          //正在热映
          void IsHotSuccess(IsHotMovieBean isHotMovieBean);
          //即将
          void upComingSuccess(UpComingBean upComingBean);
          //热门电影
          void hotSuccess(HotMovieBean hotMovieBean);

          void reserveSuccess(ReserveBean reserveBean);
      }

}
