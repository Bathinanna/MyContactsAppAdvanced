package com.mycontactsapp.service;

import com.mycontactsapp.auth.*;
import com.mycontactsapp.model.*;
import com.mycontactsapp.session.*;

import java.util.Optional;

public class LoginService {

    private AuthenticationStrategy authStrategy;

    // constructor injection
    public LoginService(AuthenticationStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }


    // login method
    public Optional<User> login(String email, String password) {
        Optional<User> user = authStrategy.authenticate(email, password);
        user.ifPresent(u ->
                SessionManager.getInstance().login(u)
        );
        return user;
    }
}