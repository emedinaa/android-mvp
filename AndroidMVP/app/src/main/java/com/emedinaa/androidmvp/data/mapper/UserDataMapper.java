package com.emedinaa.androidmvp.data.mapper;

import com.emedinaa.androidmvp.data.entity.UserEntity;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;
import com.emedinaa.androidmvp.model.entity.User;

/**
 * Created by em on 19/04/16.
 */
public class UserDataMapper {

    public User transform(UserEntity userEntity)
    {
        User user= new User();
        return user;
    }


    public User transform(LoginResponse loginResponse)
    {
        User user= new User();
        if(loginResponse!=null)
        {
            user.setEmail(loginResponse.getEmail());
            user.setName(loginResponse.getName());
            user.setObjectId(loginResponse.getObjectId());
            user.setToken(loginResponse.getToken());
        }
        return user;
    }
}
