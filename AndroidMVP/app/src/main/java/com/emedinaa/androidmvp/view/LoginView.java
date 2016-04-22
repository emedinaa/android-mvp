package com.emedinaa.androidmvp.view;

import android.content.Context;

import com.emedinaa.androidmvp.model.entity.User;

/**
 * Created by emedinaa on 21/08/15.
 */
public interface LoginView  extends BaseView{


    void showLoading();
    void hideLoading();
    void gotoMain(User user);
    void showMessageError(String message);

}
