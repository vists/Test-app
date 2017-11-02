package com.test.app.myapplication.presenter;

import com.test.app.myapplication.pojo.UserData;
import com.test.app.myapplication.baseinteractor.InteractorGetData;
import com.test.app.myapplication.presenter.basepresenter.BasePresenter;
import com.test.app.myapplication.presenter.basepresenter.router.BaseRouter;
import com.test.app.myapplication.presenter.basepresenter.view.BaseView;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by Vist on 08.09.2016.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityPresenter.ViewPresenter, MainActivityPresenter.RouterPresenter> {

    private final InteractorGetData mInteractorGetData;
    private List<UserData> mUserDataList;

    @Inject
    public MainActivityPresenter(InteractorGetData interactorGetData) {
        this.mInteractorGetData = interactorGetData;

    }

    @Override
    public void init() {
        if(isExistView())getView().onCreateAdapter();
    }

    @Override
    public void onDestroy() {
        mInteractorGetData.unsubscribe();
    }

    @Override
    public void onStart() {
        if (mUserDataList == null)
            getDataUser();
    }

    @Override
    public void onStop() {
        mInteractorGetData.unsubscribe();
    }

    public interface ViewPresenter extends BaseView {
        void onCreateAdapter();

        void onSetItems(List<UserData> userDataList);

        void onShowError(String message);
    }

    public interface RouterPresenter extends BaseRouter {

    }

    private void getDataUser() {
        mInteractorGetData.execute(null, new DisposableSingleObserver<List<UserData>>() {
            @Override
            public void onSuccess(List<UserData> userData) {
                if (userData != null)
                    if (userData.size() > 0) {
                        mUserDataList = userData;
                        if(isExistView())getView().onSetItems(userData);
                    }
            }

            @Override
            public void onError(Throwable e) {
                if(e != null)
                    if(e.getMessage() != null)
                if(isExistView())getView().onShowError(e.getMessage());
            }
        });
    }
}

