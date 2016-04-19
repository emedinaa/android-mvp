package com.emedinaa.androidmvp.data.mapper;

import com.emedinaa.androidmvp.data.entity.UserEntity;
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
}
