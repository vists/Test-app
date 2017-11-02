package com.test.app.myapplication;

import com.test.app.myapplication.injection.provider.GetUserDataProvider;
import com.test.app.myapplication.pojo.UserData;
import com.test.app.myapplication.presenter.MainActivityPresenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import java.util.ArrayList;
import javax.inject.Inject;
import io.reactivex.Single;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = AppTest.class,
        constants = BuildConfig.class,
        sdk = 21)

@Ignore
public class MainActivityPresenterTest {

        @Inject
        public MainActivityPresenter mMainActivityPresenter;

        @Inject
        GetUserDataProvider mGetUserDataProvider;

        @Mock
        public MainActivityPresenter.ViewPresenter mViewPresenter;

        @Mock
        public MainActivityPresenter.RouterPresenter mRouterPresenter;

        @Before
        public void setUp() throws Exception {
                AppTest.getInstance().getTestComponent().plusMainTestActivityComponent().inject(this);
                MockitoAnnotations.initMocks(this);
                mMainActivityPresenter.setView(mViewPresenter);
                mMainActivityPresenter.setRouter(mRouterPresenter);
                mMainActivityPresenter.init();
        }

        @Test
        public void testValidGetDataUser() {
                ArrayList<UserData> mockDataList  = new ArrayList<>();
                mockDataList.add(new UserData());
                Mockito.when(mGetUserDataProvider.getUserData()).thenReturn(Single.just(mockDataList));
                mMainActivityPresenter.onStart();
                verify(mViewPresenter).onSetItems(any());
        }

        @Test
        public void testErrorGetDataUser() {
                Mockito.when(mGetUserDataProvider.getUserData()).thenReturn(Single.error(new Throwable("Error")));
                mMainActivityPresenter.onStart();
                verify(mViewPresenter).onShowError(any());
        }


        @After
        public void complete() throws Exception {
                mMainActivityPresenter.onStop();
        }

}
