package com.mycontactsapp.command;

import com.mycontactsapp.model.*;

public class UpdateNameCommand implements ProfileCommand {

    private User user;
    private String newName;

    public UpdateNameCommand(User user, String newName) {
        this.user = user;
        this.newName = newName;
    }

    @Override
    public void execute() {

        // update user's name
        user.setName(newName);
    }
}