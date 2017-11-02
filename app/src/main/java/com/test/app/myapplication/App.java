package com.test.app.myapplication;

import android.app.Application;
import com.test.app.myapplication.injection.component.AppComponent;
import com.test.app.myapplication.injection.component.DaggerAppComponent;

/**
 * Created by Vist on 09.09.2016.
 */
public class App  extends Application{
    private static App mInstance;
    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mComponent = DaggerAppComponent.builder()
                .build();
}

    public static App getInstance(){
        return mInstance;
    }

    public AppComponent getComponent() {
        return mComponent;
    }

}
