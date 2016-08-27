package com.ecasona.rxjavaapplication.net;

import com.ecasona.rxjavaapplication.entity.Result;
import com.ecasona.rxjavaapplication.entity.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/25.
 */
public interface Request {
    @GET("/user/single")
    Observable<Result<User>> getUser(@Query("name") String name);

}
