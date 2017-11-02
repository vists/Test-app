package com.test.app.myapplication.api;

import com.test.app.myapplication.pojo.UserData;
import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Vist on 29.12.2016.
 */

public interface UserApi {
    @GET("comments")
    Single<List<UserData>> getUserDataList();
}
