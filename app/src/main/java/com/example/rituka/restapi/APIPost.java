package com.example.rituka.restapi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by rituka on 12/10/17.
 */

public class APIPost {

    private static APIPost apiPost;

    private Signin user;

    public Signin getSignin(){
        return user;
    }

    private APIPost(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://young-falls-50132.herokuapp.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                ).build();
        user=retrofit.create(Signin.class);
    }

    public static APIPost getApiPost(){
        if(apiPost==null){
            apiPost=new APIPost();
        }
        return apiPost;
    }
}
