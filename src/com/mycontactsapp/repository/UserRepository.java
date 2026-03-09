package com.mycontactsapp.repository;


import com.mycontactsapp.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    // store users using email as key
    private static Map<String, User> users = new HashMap<>();


    // save user to repository
    public static void save(User user) {
        users.put(user.getEmail(), user);
    }


    // find user by email
    public static Optional<User> findByEmail(String email) {
        return Optional.ofNullable(users.get(email));
    }
}