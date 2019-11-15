package com.bawie.weidu_movie.view.interfaces;

import com.bawie.weidu_movie.model.bean.CinemaDetailsBean;
import com.bawie.weidu_movie.model.bean.CodeBean;
import com.bawie.weidu_movie.model.bean.FindAllCinemaCommentBean;
import com.bawie.weidu_movie.model.bean.HotMovieBean;
import com.bawie.weidu_movie.model.bean.IsHotMovieBean;
import com.bawie.weidu_movie.model.bean.LoginBean;
import com.bawie.weidu_movie.model.bean.MovieFragBannerBean;
import com.bawie.weidu_movie.model.bean.RegisterBean;
import com.bawie.weidu_movie.model.bean.ReserveBean;
import com.bawie.weidu_movie.model.bean.SearchBean;
import com.bawie.weidu_movie.model.bean.UpComingBean;
import com.bawie.weidu_movie.model.bean.WXLoginBean;

/**
 * 作者： 姓名
 * 日期： 2019/11/5 15:57
 */
public interface IContractView {
    //登录
     interface iMovieLogin extends IBaseView{
         void loginSuccess(LoginBean loginBean);
         void loginWXSuccess(WXLoginBean wxLoginBean);
     }
     //注册
    interface iMovieRegister extends  IBaseView{
         void registerSuccess(RegisterBean registerBean);
         void sendCode(CodeBean codeBean);

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
      //根据关键字搜索电影信息
    interface iMovieSearch extends IBaseView{
         void searchSuccess(SearchBean searchBean);
      }
    //根据关键字查询电影信息
    interface ICinemaDetailsView extends IBaseView{
        void cinemaDetailsSuccess(CinemaDetailsBean cinemaDetailsBean);
        void cinemaDetailsError(String msg);
    }
    //查询影院用户评论列表
    interface IAllCinemaCommentView extends IBaseView{
        void allCinemaCommentSuccess(FindAllCinemaCommentBean findAllCinemaCommentBean);
        void allCinemaCommentError(String msg);
    }
}
