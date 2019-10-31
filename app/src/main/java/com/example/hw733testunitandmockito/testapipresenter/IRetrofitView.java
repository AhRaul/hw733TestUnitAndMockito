package com.example.hw733testunitandmockito.testapipresenter;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface IRetrofitView extends MvpView {

    @StateStrategyType(value = AddToEndStrategy.class)
    void showName(String name);
}
