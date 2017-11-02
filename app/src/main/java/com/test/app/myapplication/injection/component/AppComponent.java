package com.test.app.myapplication.injection.component;


import com.test.app.myapplication.App;
import com.test.app.myapplication.injection.component.mainactivity.MainActivityComponent;
import com.test.app.myapplication.injection.module.AppModule;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by Vist on 09.09.2016.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App appContext);
    MainActivityComponent plusMainActivityComponent();
}
