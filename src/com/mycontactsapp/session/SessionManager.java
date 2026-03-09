package com.mycontactsapp.session;

import com.mycontactsapp.model.*;

public class SessionManager {

    // single instance
    private static SessionManager instance;
    private User loggedInUser;
    
    // private constructor
    private SessionManager() {}
    // get singleton instance
    public static SessionManager getInstance() {
        if(instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }


    // create session
    public void login(User user) {
        this.loggedInUser = user;
    }


    // logout user
    public void logout() {
        this.loggedInUser = null;
    }


    // get current logged user
    public User getLoggedInUser() {
        return loggedInUser;
    }


    // check if logged in
    public boolean isLoggedIn() {
        return loggedInUser != null;
    }
}