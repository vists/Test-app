package com.test.app.myapplication.injection.component.mainactivity;

import com.test.app.myapplication.MainActivityPresenterTest;
import com.test.app.myapplication.injection.annotation.PerTestPresenter;
import com.test.app.myapplication.injection.module.mainactivitymodule.MainActivityTestModule;
import dagger.Subcomponent;


/**
 * Created by Vist on 01.11.2017.
 */
@PerTestPresenter
@Subcomponent(modules = MainActivityTestModule.class)
public interface MainActivityTestComponent {
    void inject(MainActivityPresenterTest mainActivityPresenterTest);
}
