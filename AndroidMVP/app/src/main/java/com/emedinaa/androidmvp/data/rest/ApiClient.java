package com.emedinaa.androidmvp.data.rest;

import com.emedinaa.androidmvp.ui.BuildConfig;
import com.squareup.okhttp.OkHttpClient;
import java.util.concurrent.TimeUnit;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

import com.emedinaa.androidmvp.data.entity.request.LogInRaw;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;

/**
 * Created by emedinaa on 16/04/16.
 */
public class ApiClient {

    private static ServicesApiInterface servicesApiInterface;

    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BuildConfig.HOST)
                    .setClient(new OkClient(getClient()))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            servicesApiInterface = restAdapter.create(ServicesApiInterface.class);
        }
        return servicesApiInterface;
    }

    public interface ServicesApiInterface {
        @Headers("Content-Type: application/json")
        @POST("/api/login")
        void login(@Body LogInRaw raw, Callback<LoginResponse> callback);
    }

    private static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(2, TimeUnit.MINUTES);
        client.setReadTimeout(2, TimeUnit.MINUTES);
        return client;
    }
}
