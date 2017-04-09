package com.emedinaa.androidmvp.data.rest;

import com.emedinaa.androidmvp.data.entity.request.LogInRaw;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;
import com.emedinaa.androidmvp.ui.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by emedinaa on 16/04/16.
 */
public class ApiClient {

    private static ServicesApiInterface servicesApiInterface;
    private static OkHttpClient.Builder httpClient;

    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            Retrofit.Builder builder =new Retrofit.Builder()
                    .baseUrl(BuildConfig.HOST)
                    .addConverterFactory(GsonConverterFactory.create());
            httpClient =new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            servicesApiInterface = retrofit.create(ServicesApiInterface.class);

            /*RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BuildConfig.HOST)
                    .setClient(new OkClient(getClient()))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();

            servicesApiInterface = restAdapter.create(ServicesApiInterface.class);*/
        }
        return servicesApiInterface;
    }

    public interface ServicesApiInterface {

        @Headers("Content-Type: application/json")
        @POST("/api/login")
        Call<LoginResponse> login(@Body LogInRaw raw);

        /*
        @Headers("Content-Type: application/json")
        @POST("/api/login")
        void login(@Body LogInRaw raw, Callback<LoginResponse> callback);*/
    }

    /*private static OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(2, TimeUnit.MINUTES);
        client.setReadTimeout(2, TimeUnit.MINUTES);
        return client;
    }*/

    private  static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
