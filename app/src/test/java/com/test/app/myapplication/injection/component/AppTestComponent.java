package com.test.app.myapplication.injection.component;

import com.test.app.myapplication.injection.component.mainactivity.MainActivityTestComponent;
import com.test.app.myapplication.injection.module.AppTestModule;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Vist on 09.09.2016.
 */

@Singleton
@Component(modules = AppTestModule.class)
public interface AppTestComponent {
    MainActivityTestComponent plusMainTestActivityComponent();
}
