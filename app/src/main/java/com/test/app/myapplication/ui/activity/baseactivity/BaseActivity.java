package com.test.app.myapplication.ui.activity.baseactivity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.test.app.myapplication.presenter.basepresenter.BasePresenter;


/**
 * Created by Vist on 08.09.2016.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @NonNull
    protected abstract BasePresenter getPresenter();

    @NonNull
    protected abstract Object getMainComponent();


}
