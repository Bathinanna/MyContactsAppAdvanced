package com.mycontactsapp.command;

import com.mycontactsapp.model.*;
import com.mycontactsapp.util.*;

public class ChangePasswordCommand implements ProfileCommand {

    private User user;
    private String newPassword;

    public ChangePasswordCommand(User user, String newPassword) {
        this.user = user;
        this.newPassword = newPassword;
    }

    @Override
    public void execute() {

        if(!ValidationUtil.isValidPassword(newPassword)) {
            throw new RuntimeException("Invalid password");
        }

        String hash = PasswordUtil.hashPassword(newPassword);

        user.setPasswordHash(hash);
    }
}