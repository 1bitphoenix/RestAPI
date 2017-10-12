package com.example.rituka.restapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rituka on 12/10/17.
 */

public class API {
    private static API apiInstance;

    private UserName userName;

    public UserName getUserName(){
        return userName;
    }

    private API(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://testresapi.herokuapp.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        userName=retrofit.create(UserName.class);
    }



    public static API getApiInstance(){
        if(apiInstance==null){
            apiInstance=new API();
        }
        return apiInstance;
    }
}
