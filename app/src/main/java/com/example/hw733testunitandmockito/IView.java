package com.example.hw733testunitandmockito;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface IView extends MvpView {

    @StateStrategyType(value = AddToEndStrategy.class)
    void setButtonText(int x);
}
