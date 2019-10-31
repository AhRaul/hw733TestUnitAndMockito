package com.example.hw733testunitandmockito.api;

import com.example.hw733testunitandmockito.testapipresenter.RetrofitPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {
    void inject(RetrofitPresenter presenter);
}
