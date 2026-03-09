package com.mycontactsapp.command;

import com.mycontactsapp.model.*;

public class UpdatePreferenceCommand implements ProfileCommand {

    private User user;
    private String key;
    private String value;

    public UpdatePreferenceCommand(User user, String key, String value) {

        this.user = user;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {

        user.setPreference(key, value);
    }
}