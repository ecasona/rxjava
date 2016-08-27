package com.ecasona.rxjavaapplication.net;

import com.ecasona.rxjavaapplication.entity.Result;
import com.ecasona.rxjavaapplication.entity.User;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/25.
 */
public class NetRequset {

    public static final String IP = "http://192.168.1.121:8080";

    private static NetRequset netRequset;

    private Request request;

    private NetRequset() {
        initRetrofit();
    }

    public synchronized static NetRequset getNetRequset() {
        if (null == netRequset) {
            netRequset = new NetRequset();
        }
        return netRequset;
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IP)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        request = retrofit.create(Request.class);
    }

    public void getUser(Subscriber<Result<User>> subscriber, String name) {
        request.getUser(name)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
