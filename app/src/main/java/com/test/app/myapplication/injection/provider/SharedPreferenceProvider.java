package com.test.app.myapplication.injection.provider;

import android.content.Context;
import android.content.SharedPreferences;
import com.test.app.myapplication.App;
import javax.inject.Inject;
import io.reactivex.Single;

/**
 * Created by Vist on 12.09.2016.
 */

public class SharedPreferenceProvider {

    private final String NAME_PREFS = "SharedPref";
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    @Inject
    public SharedPreferenceProvider() {
        preferences = App.getInstance().getSharedPreferences(NAME_PREFS, Context.MODE_PRIVATE);
        edit = preferences.edit();

    }

    public Single<String> getPrefsByKey(String key) {
        if (!preferences.contains(key))
            return Single.just("");
        else
            return Single.just(preferences.getString(key, ""));
    }

    public void putPrefsByKeyWithoutObservable(String key, String value) {
        edit.putString(key, value);
        edit.apply();
    }

    public String getPrefsByKeyWithoutObservable(String key) {
        if (preferences.contains(key))
            return preferences.getString(key, null);
        else
            return null;
    }

}
