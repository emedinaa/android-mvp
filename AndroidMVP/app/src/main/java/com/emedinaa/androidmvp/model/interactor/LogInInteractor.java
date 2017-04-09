package com.emedinaa.androidmvp.model.interactor;

import android.util.Log;

import com.emedinaa.androidmvp.data.entity.request.LogInRaw;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;
import com.emedinaa.androidmvp.data.mapper.UserDataMapper;
import com.emedinaa.androidmvp.data.rest.ApiClient;
import com.emedinaa.androidmvp.model.entity.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by em on 22/04/16.
 */
public class LogInInteractor {

    private static final String TAG = "LogInInteractor";
    private final UserDataMapper userDataMapper;

    public LogInInteractor(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public void logIn(String email, String password,final LogInCallback logInCallback)
    {
        LogInRaw logInRaw= new LogInRaw();
        logInRaw.setUsername(email);
        logInRaw.setPassword(password);

        Call<LoginResponse> call = ApiClient.getMyApiClient().login(logInRaw);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse= response.body();
                    User user= userDataMapper.transformResponse(loginResponse);
                    logInCallback.onLogInSuccess(user);
                }else {
                    logInCallback.onLogInError("an error occurred...");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String json="Error ";
                try {
                    json= new StringBuffer().append(t.getMessage()).toString();
                }catch (NullPointerException e) {}
                Log.v(TAG, "json >>>> " + json);

                logInCallback.onLogInError(json);
            }
        });

        /*ApiClient.getMyApiClient().login(logInRaw, new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                if(loginResponse!=null){
                    User user= userDataMapper.transformResponse(loginResponse);
                    logInCallback.onLogInSuccess(user);
                }else{
                    logInCallback.onLogInError("an error occurred...");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String message= "";
                if(error!=null)message= error.getMessage();
                logInCallback.onLogInError(message);
            }
        });*/
    }
}
