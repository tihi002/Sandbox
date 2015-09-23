package com.gmail.rozman.tihamer.POJOs;

import java.io.Serializable;

/**
 * Created by trozman on 2015. 09. 23..
 */
public class User implements Serializable {

    private String userName;
    private String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String toString() {
        return getUserName() + ", " + getUserPassword();
    }

}
