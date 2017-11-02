package com.test.app.myapplication.injection.component.mainactivity;

import com.test.app.myapplication.injection.anotation.PerActivity;
import com.test.app.myapplication.injection.module.mainactivitymodule.MainActivityModule;
import com.test.app.myapplication.ui.activity.MainActivity;
import dagger.Subcomponent;


/**
 * Created by Vist on 01.11.2017.
 */
@PerActivity
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
