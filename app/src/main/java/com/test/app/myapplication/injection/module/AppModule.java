package com.test.app.myapplication.injection.module;

import com.test.app.myapplication.injection.anotation.Job;
import com.test.app.myapplication.injection.anotation.Main;
import com.test.app.myapplication.injection.provider.RetrofitServiceProvider;
import com.test.app.myapplication.injection.provider.SharedPreferenceProvider;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vist on 12.09.2016.
 */
@Module
public class AppModule {

    @Provides
    @Job
    Scheduler provideJobScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Main
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Singleton
    @Provides
    SharedPreferenceProvider provideSharedPreference() {
        return new SharedPreferenceProvider();
    }

    @Singleton
    @Provides
    RetrofitServiceProvider provideRetrofitService() {
        return new RetrofitServiceProvider();
    }

}
