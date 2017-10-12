package com.example.rituka.restapi;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by rituka on 12/10/17.
 */

public interface Signin {
    @POST("/api/v1/user_token")
    Call<Token> getToken(
            @Body Auth auth
    );
}
