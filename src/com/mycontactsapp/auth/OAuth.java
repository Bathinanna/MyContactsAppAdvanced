package com.mycontactsapp.auth;

import com.mycontactsapp.model.*;
import com.mycontactsapp.repository.*;

import java.util.Optional;

public class OAuth implements AuthenticationStrategy {

    // simple token prefix used to simulate OAuth
    private static final String VALID_TOKEN_PREFIX = "OAUTH_";
    @Override
    public Optional<User> authenticate(String email, String token) {
        // find user from repository
        Optional<User> userOptional = UserRepository.findByEmail(email);
        // if user does not exist
        if (userOptional.isEmpty()) {
            return Optional.empty();
        }
        // simple token validation logic
        if (token != null && token.startsWith(VALID_TOKEN_PREFIX)) {
            // token accepted → authentication successful
            return userOptional;
        }
        // invalid token
        return Optional.empty();
    }
}