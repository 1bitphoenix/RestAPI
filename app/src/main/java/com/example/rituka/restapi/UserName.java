package com.example.rituka.restapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rituka on 12/10/17.
 */

public interface UserName {
    @GET("/posts")
    Call<String> getName(
        @Query("name") String userName
    );
}
