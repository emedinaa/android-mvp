package com.emedinaa.androidmvp.data.entity.request;

/**
 * Created by em on 22/04/16.
 */
public class LogInRaw {
    /*
        {
            "username": "emedinaa@gmail.com",
            "password": "123456"
        }
     */
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
