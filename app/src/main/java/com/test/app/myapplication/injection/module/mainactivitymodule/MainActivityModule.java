package com.test.app.myapplication.injection.module.mainactivitymodule;

import com.test.app.myapplication.injection.anotation.PerActivity;
import com.test.app.myapplication.injection.provider.GetUserDataProvider;
import com.test.app.myapplication.injection.provider.RetrofitServiceProvider;
import com.test.app.myapplication.injection.provider.SharedPreferenceProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Vist on 12.09.2016.
 */
@Module
public class MainActivityModule {

    @PerActivity
    @Provides
    GetUserDataProvider provideUserData(RetrofitServiceProvider retrofitServiceTestProvider, SharedPreferenceProvider sharedPreferenceTestProvider) {
        return new GetUserDataProvider(retrofitServiceTestProvider,sharedPreferenceTestProvider);
    }

}
