package com.bawie.weidu_movie.model.api;

import com.bawie.weidu_movie.model.bean.CodeBean;
import com.bawie.weidu_movie.model.bean.HotMovieBean;
import com.bawie.weidu_movie.model.bean.IsHotMovieBean;
import com.bawie.weidu_movie.model.bean.LoginBean;
import com.bawie.weidu_movie.model.bean.MovieFragBannerBean;
import com.bawie.weidu_movie.model.bean.RegisterBean;
import com.bawie.weidu_movie.model.bean.SearchBean;
import com.bawie.weidu_movie.model.bean.UpComingBean;
import com.bawie.weidu_movie.model.bean.WXLoginBean;
import com.bawie.weidu_movie.model.url.CantantUrl;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 作者： 姓名
 * 日期： 2019/11/6 11:54
 */
public interface IApi {
    @FormUrlEncoded
    //登录
    @POST(CantantUrl.LOGIN_URL)
    Observable<LoginBean>movieLogin(@Field("email")String email,@Field("pwd")String pwd);

    //微信登录
    @FormUrlEncoded
    @POST(CantantUrl.WXLOGIN_URL)
    Observable<WXLoginBean>movieWXLogin(@Field("code") String code);

    //发送验证码
    @FormUrlEncoded
    @POST(CantantUrl.SENDCODE_URL)
    Observable<CodeBean>sendCode(@Field("email") String email);

    //注册
    @FormUrlEncoded
    @POST(CantantUrl.REGISTER_URL)
    Observable<RegisterBean>movieRegister(@Field("nickName") String nickName,
                                          @Field("pwd") String pwd,
                                          @Field("email") String email,
                                          @Field("code") String code);
    //首页展示Banner
    @GET(CantantUrl.MOVIEBANNER_URL)
    Observable<MovieFragBannerBean> movieBanner();

    //首页正在热映
    @GET(CantantUrl.ISHITMOVIE_URL)
    Observable<IsHotMovieBean>isHotMovie(@Query("page")int page,@Query("count")int count);

    //首页即将上映
    @GET(CantantUrl.UPCOMING_URL)
    Observable<UpComingBean> upComingMovie(@Query("page") int page,
                                           @Query("count") int count);

    //首页展示热门电影
    @GET(CantantUrl.HOT_URL)
    Observable<HotMovieBean> hotMovie(@Query("page") int page,
                                      @Query("count") int count);

    //根据关键字查询电影信息
    @GET(CantantUrl.MovieByKeyword_URL)
    Observable<SearchBean> movieSearch(@Query("keyword") String keyword,
                                          @Query("page") int page,
                                          @Query("count") int count);

}
