package com.emedinaa.androidmvp.data.entity.response;

import java.io.Serializable;

/**
 * Created by emedinaa on 19/05/15.
 */
public class LoginResponse implements Serializable {

    /*{
        "createdAt": "2015-05-19T20:11:22.931Z",
            "objectId": "fSVL0hhKgc",
            "sessionToken": "r:PxcekgeZiG3afFZGArdZdQ54w",
            "updatedAt": "2015-05-19T20:30:00.793Z",
            "username": "emedinaa"
    }*/

    private  String createdAt;
    private  String objectId;
    private  String sessionToken;
    private  String updatedAt;
    private  String username;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "createdAt='" + createdAt + '\'' +
                ", objectId='" + objectId + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
