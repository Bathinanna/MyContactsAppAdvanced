package com.mycontactsapp.auth;

import com.mycontactsapp.model.*;

import java.util.Optional;

public interface AuthenticationStrategy {

    // authenticate user
    Optional<User> authenticate(String email, String password);
}