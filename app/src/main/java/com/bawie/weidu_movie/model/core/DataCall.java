package com.bawie.weidu_movie.model.core;

import com.bawie.weidu_movie.model.wangben.Bean;

/**
 * 作者:王帅
 * 时间:2019/11/11
 * 功能:
 */
public interface DataCall<T> {
    void Seccess(T t);
    void Fails(Bean b);

}
