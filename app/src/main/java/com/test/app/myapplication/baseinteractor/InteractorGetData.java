package com.test.app.myapplication.baseinteractor;


import com.test.app.myapplication.pojo.UserData;
import com.test.app.myapplication.injection.anotation.Job;
import com.test.app.myapplication.injection.anotation.Main;
import com.test.app.myapplication.injection.provider.GetUserDataProvider;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Scheduler;
import io.reactivex.Single;

/**
 * Created by Vist on 18.10.2016.
 */

public class InteractorGetData extends BaseInteractor<List<UserData>, Object> {
    final GetUserDataProvider mGetUserDataProvider;

    @Inject
    public InteractorGetData(@Job Scheduler jobScheduler, @Main Scheduler uiScheduler, GetUserDataProvider mGetUserDataProvider) {
        super(jobScheduler, uiScheduler);
        this.mGetUserDataProvider = mGetUserDataProvider;
    }

    @Override
    protected Single<List<UserData>> buildSingle(Object parameter) {
        return  mGetUserDataProvider.getUserData();
    }
}
