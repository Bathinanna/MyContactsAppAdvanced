package com.mycontactsapp.auth;
import com.mycontactsapp.model.*;
import com.mycontactsapp.repository.*;
import com.mycontactsapp.util.*;

import java.util.Optional;

public class BasicAuth implements AuthenticationStrategy {

    @Override
    public Optional<User> authenticate(String email, String password) {
        // find user from repository
        Optional<User> userOptional = UserRepository.findByEmail(email);
        if(userOptional.isEmpty())
            return Optional.empty();
        User user = userOptional.get();
        // hash entered password
        String hash = PasswordUtil.hashPassword(password);
        // compare hashed password
        if(hash.equals(user.getPasswordHash())) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}