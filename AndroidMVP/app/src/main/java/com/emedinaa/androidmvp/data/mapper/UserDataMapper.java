package com.emedinaa.androidmvp.data.mapper;

import com.emedinaa.androidmvp.data.entity.UserEntity;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;
import com.emedinaa.androidmvp.model.entity.User;

/**
 * Created by em on 19/04/16.
 */
public class UserDataMapper {

    private User transform(UserEntity userEntity)
    {
        User user= new User();
        if(userEntity==null) return user;

        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());

        return user;
    }

    public User transformResponse(LoginResponse loginResponse)
    {
        User user= new User();
        if(loginResponse==null)return user;
        user= transform(loginResponse.getData());
        return user;
    }
}
