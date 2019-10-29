package com.example.hw733testunitandmockito;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MyPresenter extends MvpPresenter<IView> {

    private Model model;


    public MyPresenter() {
        this.model = new Model();
    }

    public void noButtonClick() {
        getViewState().setButtonText(model.summ(3, 2));
    }
}
