package com.emedinaa.androidmvp.presenter;

import android.util.Log;

import com.emedinaa.androidmvp.R;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;
import com.emedinaa.androidmvp.data.mapper.UserDataMapper;
import com.emedinaa.androidmvp.model.entity.User;
import com.emedinaa.androidmvp.model.interactor.LogInCallback;
import com.emedinaa.androidmvp.model.interactor.LogInInteractor;
import com.emedinaa.androidmvp.view.LoginView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emedinaa on 21/08/15.
 */
public class LoginPresenter implements Presenter<LoginView>,LogInCallback{

    private static final String TAG ="LoginPresenter" ;
    private LoginView loginView;
    private LogInInteractor logInInteractor;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        logInInteractor= new LogInInteractor(new UserDataMapper());
    }

    public void login(String email, String password)
    {
        loginView.showLoading();
        logInInteractor.logIn(email,password,this);
    }


    @Override
    public void addView(LoginView view) {
        this.loginView= view;
    }

    @Override
    public void removeView() {
        this.loginView=null;
    }

    @Override
    public void onLogInSuccess(Object object) {
        loginView.hideLoading();
        User user= (User)(object);
        loginView.gotoMain(user);

    }

    @Override
    public void onLogInError(Object object) {
        loginView.hideLoading();
    }
}
