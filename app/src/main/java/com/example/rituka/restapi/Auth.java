package com.example.rituka.restapi;

/**
 * Created by rituka on 12/10/17.
 */

public class Auth {
    AuthSub auth;

    public AuthSub getAuth() {
        return auth;
    }

    public void setAuth(AuthSub auth) {
        this.auth = auth;
    }

    public Auth() {
        this.auth = new AuthSub();

    }
}
