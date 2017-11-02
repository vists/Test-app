package com.test.app.myapplication.injection.module;

import com.test.app.myapplication.injection.anotation.Job;
import com.test.app.myapplication.injection.anotation.Main;
import com.test.app.myapplication.injection.provider.RetrofitServiceProvider;
import com.test.app.myapplication.injection.provider.SharedPreferenceProvider;
import org.mockito.Mockito;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vist on 12.09.2016.
 */
@Module
public class AppTestModule {

    @Provides
    @Job
    Scheduler provideJobScheduler() {
        return Schedulers.trampoline();
    }

    @Provides
    @Main
    Scheduler provideMainScheduler() {
        return Schedulers.trampoline();
    }

    @Singleton
    @Provides
    SharedPreferenceProvider provideSharedPreference() {
        return Mockito.mock(SharedPreferenceProvider.class);
    }

    @Singleton
    @Provides
    RetrofitServiceProvider provideRetrofitService() {
        return Mockito.mock(RetrofitServiceProvider.class);
    }

}
