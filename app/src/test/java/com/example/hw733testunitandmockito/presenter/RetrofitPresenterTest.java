package com.example.hw733testunitandmockito.presenter;

import com.example.hw733testunitandmockito.api.DaggerTestComponent;
import com.example.hw733testunitandmockito.api.TestComponent;
import com.example.hw733testunitandmockito.api.TestModule;
import com.example.hw733testunitandmockito.testapipresenter.IRetrofitView;
import com.example.hw733testunitandmockito.testapipresenter.RetrofitApi;
import com.example.hw733testunitandmockito.testapipresenter.RetrofitPresenter;
import com.example.hw733testunitandmockito.testapipresenter.User;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class RetrofitPresenterTest {

    private RetrofitPresenter presenter;

    @Mock
    IRetrofitView retrofitView;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(     //Обход многопоточности
                __ -> Schedulers.trampoline());                 //?? Что это за полоска такая??
    }

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.spy(new RetrofitPresenter());
    }

    @Test
    public void getString_isCorrect() {
        TestComponent component = DaggerTestComponent.builder()
                .testModule(new TestModule() {
                    @Override
                    public RetrofitApi provideRetrofitApi() {
                        RetrofitApi retrofitApi = super.provideRetrofitApi();
                        User user = new User();
                        user.login = "Jack";
                        Mockito.when(retrofitApi.requestServer()).thenReturn(Observable.just(user));
                        return retrofitApi;
                    }
                }).build();

        component.inject(presenter);
        presenter.attachView(retrofitView);
        presenter.getString();
        Mockito.verify(retrofitView).showName("Jack");

    }
}
