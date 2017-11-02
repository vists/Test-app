package com.test.app.myapplication.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.widget.Toast;
import com.test.app.myapplication.App;
import com.test.app.myapplication.R;
import com.test.app.myapplication.pojo.UserData;
import com.test.app.myapplication.databinding.ActivityMainBinding;
import com.test.app.myapplication.injection.component.mainactivity.MainActivityComponent;
import com.test.app.myapplication.presenter.MainActivityPresenter;
import com.test.app.myapplication.ui.activity.adapter.UserDataAdapter;
import com.test.app.myapplication.ui.activity.baseactivity.BaseActivity;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityPresenter.ViewPresenter, MainActivityPresenter.RouterPresenter {
    @Inject
    MainActivityPresenter mPresenter;
    private MainActivityComponent mainActivityComponent;
    private ActivityMainBinding mBinding;
    private UserDataAdapter mUserDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityComponent = App.getInstance().getComponent().plusMainActivityComponent();
        getMainComponent().inject(this);
        getPresenter().setView(this);
        getPresenter().setRouter(this);
        getPresenter().init();
    }

    @Override
    protected void onStart() {
        getPresenter().onStart();
        super.onStart();
    }

    @Override
    protected void onStop() {
        getPresenter().onStop();
        super.onStop();
    }

    @NonNull
    @Override
    protected MainActivityPresenter getPresenter() {
        return mPresenter;
    }

    @NonNull
    @Override
    protected MainActivityComponent getMainComponent() {
        return mainActivityComponent;
    }

    @Override
    public void onCreateAdapter() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mBinding.recyclerViewUserDataActivityMain.setLayoutManager(mLayoutManager);
        mUserDataAdapter = new UserDataAdapter();
        mBinding.recyclerViewUserDataActivityMain.setAdapter(mUserDataAdapter);
    }

    @Override
    public void onSetItems(List<UserData> userDataList) {
        if (mUserDataAdapter != null)
            mUserDataAdapter.setItems(userDataList);
    }

    @Override
    public void onShowError(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
