package com.test.app.myapplication.injection.provider;

import com.test.app.myapplication.App;
import com.test.app.myapplication.R;
import com.test.app.myapplication.pojo.UserData;
import com.test.app.myapplication.api.UserApi;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;
import retrofit2.HttpException;

/**
 * Created by Vist on 01.11.2017.
 */

public class GetUserDataProvider {
    private final RetrofitServiceProvider mRetrofitServiceProvider;
    private final SharedPreferenceProvider mSharedPreferenceProvider;
    private final UserApi mUserApi;

    @Inject
    public GetUserDataProvider(RetrofitServiceProvider retrofitServiceProvider, SharedPreferenceProvider sharedPreferenceProvider) {
        this.mRetrofitServiceProvider = retrofitServiceProvider;
        this.mSharedPreferenceProvider = sharedPreferenceProvider;
        this.mUserApi = mRetrofitServiceProvider.getServiceRetrofit(UserApi.class);
    }

    /* Zip if need get some data from SharedPref or DB*/
    public Single<List<UserData>> getUserData() {
        return Single.zip(mSharedPreferenceProvider.getPrefsByKey(""), mSharedPreferenceProvider.getPrefsByKey("")
                , mSharedPreferenceProvider.getPrefsByKey("")
                , (name, password, token) ->
                        new String[]{name, password, token})
                .flatMap(dataArray ->
                        mUserApi.getUserDataList()
                                .onErrorResumeNext(throwable -> {
                                    if (throwable instanceof HttpException)
                                        return Single.error(throwable);
                                    else
                                        return Single.error(new Throwable(App.getInstance().getString(R.string.error_connect)));
                                })
);
    }
}
