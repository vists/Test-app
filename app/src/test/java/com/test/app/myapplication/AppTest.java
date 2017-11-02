package com.test.app.myapplication;

import com.test.app.myapplication.injection.component.AppTestComponent;
import com.test.app.myapplication.injection.component.DaggerAppTestComponent;

/**
 * Created by Vist on 02.11.2017.
 */

public class AppTest extends App{
    private static AppTest mInstance;
    private AppTestComponent mComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mComponent = DaggerAppTestComponent.builder()
                .build();
    }

    public static AppTest getInstance(){
        return mInstance;
    }

    public AppTestComponent getTestComponent() {
        return mComponent;
    }

}
