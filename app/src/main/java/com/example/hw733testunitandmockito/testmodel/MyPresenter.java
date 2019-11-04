package com.example.hw733testunitandmockito.testmodel;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MyPresenter extends MvpPresenter<IView> {

    private Model model;


    public MyPresenter() {
        this.model = new Model();
    }

    public void onButtonClick() {
        getViewState().setButtonText(model.summ(3, 2));
    }
}
