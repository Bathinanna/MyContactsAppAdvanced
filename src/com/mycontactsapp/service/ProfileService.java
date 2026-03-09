package com.mycontactsapp.service;


import com.mycontactsapp.command.*;

public class ProfileService {

    // execute profile command
    public void executeCommand(ProfileCommand command) {

        command.execute();
    }
}