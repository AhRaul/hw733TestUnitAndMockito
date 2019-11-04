package com.example.hw733testunitandmockito.testapipresenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<IRetrofitView> {

    private static final String TAG = "RetrofitPresenter";

    @Inject
    RetrofitApi retrofitApi;

    public void getString() {
        Observable<User> single = retrofitApi.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            Log.d(TAG, "onNext: " + user.login);
            getViewState().showName(user.login);
        }, throwable -> {
            Log.e(TAG, "onError");
        });
    }
}
