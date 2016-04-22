package com.emedinaa.androidmvp.data.entity.response;

import java.io.Serializable;

/**
 * Created by emedinaa on 19/05/2015.
 */
public class SignInResponse  {
    /*
    {"objectId":"17CnDWgxb5","createdAt":"2015-05-20T00:57:24.596Z"}
     */
    private String objectId;
    private String createdAt;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
