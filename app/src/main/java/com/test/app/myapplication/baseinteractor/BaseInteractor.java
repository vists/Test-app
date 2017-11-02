package com.test.app.myapplication.baseinteractor;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by Vist on 08.09.2016.
 */

abstract class BaseInteractor<ResultType, ParameterType> {
    private final CompositeDisposable disposable = new CompositeDisposable();
    protected final Scheduler jobScheduler;
    private final Scheduler uiScheduler;

    public BaseInteractor(Scheduler jobScheduler, Scheduler uiScheduler) {
        this.jobScheduler = jobScheduler;
        this.uiScheduler = uiScheduler;
    }

    protected abstract Single<ResultType> buildSingle(ParameterType parameter);

    public void execute(ParameterType parameter, DisposableSingleObserver<ResultType> observer) {
        disposable.add(buildSingle(parameter)
                .subscribeOn(jobScheduler)
                .observeOn(uiScheduler)
                .subscribeWith(observer));
    }

    public void unsubscribe() {
        disposable.clear();
    }

    public boolean isSubscribe() {
        return disposable.isDisposed();
    }
}


