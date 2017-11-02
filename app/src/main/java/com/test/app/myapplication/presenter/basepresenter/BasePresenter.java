package com.test.app.myapplication.presenter.basepresenter;

import com.test.app.myapplication.presenter.basepresenter.router.BaseRouter;
import com.test.app.myapplication.presenter.basepresenter.view.BaseView;
import java.lang.ref.WeakReference;

/**
 * Created by Vist on 08.09.2016.
 */
public abstract class BasePresenter<View extends BaseView, Router extends BaseRouter> {
    private WeakReference<View> view = null;
    private WeakReference<Router> router = null;

    public abstract void init();

    public abstract void onDestroy();

    public abstract void onStart();

    public abstract void onStop();

    public void onRefreshData(){

    }

    public boolean isExistView(){
        return view.get() != null;
    }

    public boolean isExistRouter() {
        return view.get() != null;
    }

    public View getView() {
        return view.get();
    }

    public void setView(View view) {
        this.view = new WeakReference<View>(view);
    }

    public Router getRouter() {
        return router.get();
    }

    public void setRouter(Router router) {
        this.router = new WeakReference<Router>(router);
    }
}
