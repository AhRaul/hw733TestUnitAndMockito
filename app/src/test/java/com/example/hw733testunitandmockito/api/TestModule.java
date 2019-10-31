package com.example.hw733testunitandmockito.api;

import com.example.hw733testunitandmockito.testapipresenter.RetrofitApi;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {
    @Provides
    public RetrofitApi provideRetrofitApi() {
        return Mockito.mock(RetrofitApi.class);
    }
}
