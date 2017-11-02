package com.test.app.myapplication.injection.module.mainactivitymodule;

import com.test.app.myapplication.injection.annotation.PerTestPresenter;
import com.test.app.myapplication.injection.provider.GetUserDataProvider;
import org.mockito.Mockito;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Vist on 12.09.2016.
 */
@Module
public class MainActivityTestModule {

    @PerTestPresenter
    @Provides
    GetUserDataProvider provideUserDataValid() {
        return Mockito.mock(GetUserDataProvider.class);
    }

}
