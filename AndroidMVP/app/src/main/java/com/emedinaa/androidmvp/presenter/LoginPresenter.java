package com.emedinaa.androidmvp.presenter;

import com.emedinaa.androidmvp.data.mapper.UserDataMapper;
import com.emedinaa.androidmvp.model.entity.User;
import com.emedinaa.androidmvp.model.interactor.LogInCallback;
import com.emedinaa.androidmvp.model.interactor.LogInInteractor;
import com.emedinaa.androidmvp.view.LoginView;

/**
 * Created by emedinaa on 21/08/15.
 */
public class LoginPresenter implements Presenter<LoginView>,LogInCallback{

    private static final String TAG ="LoginPresenter" ;
    private LoginView loginView;
    private LogInInteractor logInInteractor;

    public LoginPresenter() {
    }

    public void login()
    {
        if(!loginView.validate())return;

        String email= loginView.getUserName();
        String password= loginView.getPassword();

        loginView.showLoading();
        logInInteractor.logIn(email,password,this);
    }


    @Override
    public void addView(LoginView view) {
        this.loginView= view;
        logInInteractor= new LogInInteractor(new UserDataMapper());
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
        String message= object.toString();
        loginView.hideLoading();
        loginView.showMessageError(message);
    }
}
