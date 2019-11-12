package com.bawie.weidu_movie.model.http;

import com.bawie.weidu_movie.model.api.IApi;
import com.bawie.weidu_movie.model.bean.CodeBean;
import com.bawie.weidu_movie.model.bean.HotMovieBean;
import com.bawie.weidu_movie.model.bean.IsHotMovieBean;
import com.bawie.weidu_movie.model.bean.LoginBean;
import com.bawie.weidu_movie.model.bean.MovieFragBannerBean;
import com.bawie.weidu_movie.model.bean.RegisterBean;
import com.bawie.weidu_movie.model.bean.SearchBean;
import com.bawie.weidu_movie.model.bean.UpComingBean;
import com.bawie.weidu_movie.model.url.CantantUrl;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： 姓名
 * 日期： 2019/11/5 16:01
 */
public class OkHttpUtils<B> {

    private static OkHttpUtils okHttpUtils = new OkHttpUtils();
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;
    private final IApi iApi;

    public static OkHttpUtils getInstance(){
        return okHttpUtils;
    }
    private OkHttpUtils(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(CantantUrl.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iApi = retrofit.create(IApi.class);
    }

    public void movielogin(IOkCallBack iOkCallBack, Class<B> loginBeanClass, String etLoginZhanghao, String etLoginMima) {
        Observable<LoginBean> login = iApi.movieLogin(etLoginZhanghao, etLoginMima);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        iOkCallBack.callSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void movieBanner(IOkCallBack<MovieFragBannerBean> hhhhhhhh, Class<B> movieFragBannerBeanClass) {
        Observable<MovieFragBannerBean> movieBanner = iApi.movieBanner();
        movieBanner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieFragBannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieFragBannerBean movieFragBannerBean) {
                        hhhhhhhh.callSuccess(movieFragBannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void IsHotMovie(IOkCallBack<IsHotMovieBean> isHotMovieBeanIOkCallBack, Class<B> isHotMovieBeanClass, int page, int count) {
        Observable<IsHotMovieBean> hitMovie = iApi.isHotMovie(page, count);
        hitMovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<IsHotMovieBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(IsHotMovieBean isHotMovieBean) {
                      isHotMovieBeanIOkCallBack.callSuccess(isHotMovieBean);
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
    }

    public void upComingMovie(IOkCallBack<UpComingBean> upComingBeanIOkCallBack, Class<B> upComingBeanClass, int page, int count) {
        Observable<UpComingBean> upComingMovie = iApi.upComingMovie(page, count);
        upComingMovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<UpComingBean>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(UpComingBean upComingBean) {
                       upComingBeanIOkCallBack.callSuccess(upComingBean);
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });

    }

    public void hotMovie(IOkCallBack<HotMovieBean> hotMovieBeanIOkCallBack, Class<B> hotMovieBeanClass, int page, int count) {
        Observable<HotMovieBean> hotMovie = iApi.hotMovie(page, count);
        hotMovie.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<HotMovieBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(HotMovieBean hotMovieBean) {
                      hotMovieBeanIOkCallBack.callSuccess(hotMovieBean);
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
    }
    //注册
    public void movieRegister(IOkCallBack<RegisterBean> registerBeanIOkCallBack, Class<B> registerBeanClass, String name, String encrypt, String email, String code) {
        Observable<RegisterBean> movieRegister = iApi.movieRegister(name, email, encrypt, code);
        movieRegister.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                          registerBeanIOkCallBack.callSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //发送验证码
    public void sendCode(IOkCallBack<CodeBean> codeBeanIOkCallBack, Class<B> codeBeanClass, String trim) {
        Observable<CodeBean> codeBeanObservable = iApi.sendCode(trim);
        codeBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeBean codeBean) {
                            codeBeanIOkCallBack.callSuccess(codeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void search(IOkCallBack<SearchBean> searchBeanIOkCallBack, Class<B> searchBeanClass, String keyword, int page, int count) {
        Observable<SearchBean> searchBeanObservable = iApi.movieSearch(keyword, page, count);
        searchBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        searchBeanIOkCallBack.callSuccess(searchBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public interface IOkCallBack<B> {
        void callSuccess(B bean);

        void callError(String msg);
    }
}
