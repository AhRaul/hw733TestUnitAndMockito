package com.example.hw733testunitandmockito;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewActivity extends MvpAppCompatActivity implements IView {

    private Button button;

    @InjectPresenter
    MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.noButtonClick();
            }
        });
    }

    @Override
    public void setButtonText(int x) {
        button.setText("3+2=" + x);
    }
}
