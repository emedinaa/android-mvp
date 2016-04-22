package com.emedinaa.androidmvp.data.entity.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by emedinaa on 19/05/15.
 */
public class LoginResponse extends BaseResponse {

    private String name;

    @SerializedName("___class")
    private String type;

    @SerializedName("user-token")
    private String token;

    private String email;

    private String objectId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
