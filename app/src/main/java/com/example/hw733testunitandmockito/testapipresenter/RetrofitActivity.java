package com.example.hw733testunitandmockito.testapipresenter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hw733testunitandmockito.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class RetrofitActivity extends MvpAppCompatActivity implements IRetrofitView {

    private static final String TAG = "RetrofitDifActivity";

    @InjectPresenter
    RetrofitPresenter retrofitPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_activity_retrofit)
    public void onClickButton(View view) {
        Log.d(TAG, "onClickButton: ");
        retrofitPresenter.getString();
    }

    @Override
    public void showName(String name) {
        Log.d(TAG, "showName: " + name);
    }
}
