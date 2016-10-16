package com.emedinaa.androidmvp.data.entity.response;

import com.emedinaa.androidmvp.data.entity.UserEntity;
/**
 * Created by emedinaa on 19/05/15.
 */
public class LoginResponse extends BaseResponse {
/*
    {
      "msg": "success",
      "status": 200,
      "data": {
        "_id": "5801bc3f3b54e30300b8bc45",
        "id": "5801bc3f3b54e30300b8bc45",
        "username": "emedinaa@gmail.com",
        "password": "123456",
        "firstname": "Eduardo",
        "lastname": "Medina",
        "__v": 0
      }
    }
 */
    private UserEntity data;

    public UserEntity getData() {
        return data;
    }

    public void setData(UserEntity data) {
        this.data = data;
    }
}
