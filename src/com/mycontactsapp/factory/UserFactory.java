package com.mycontactsapp.factory;

import com.mycontactsapp.builder.*;
import com.mycontactsapp.model.*;

public class UserFactory {

    // Creates user based on type
    public static User createUser(String type, UserBuilder builder) {

        if (type.equalsIgnoreCase("FREE")) {

            // Create free user
            return new FreeUser(
                    builder.getEmail(),
                    builder.getPasswordHash(),
                    builder.getName()
            );

        } else if (type.equalsIgnoreCase("PREMIUM")) {

            // Create premium user
            return new PremiumUser(
                    builder.getEmail(),
                    builder.getPasswordHash(),
                    builder.getName()
            );

        } else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }
}