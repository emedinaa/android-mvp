package com.emedinaa.androidmvp.presenter;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.emedinaa.androidmvp.R;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;
import com.emedinaa.androidmvp.view.LoginView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emedinaa on 21/08/15.
 */
public class LoginPresenter implements Presenter<LoginView>{

    private static final String TAG ="LoginPresenter" ;
    private LoginView loginView;
    private RequestQueue queue;
    private LoginResponse loginResponse;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password)
    {
        queue = Volley.newRequestQueue(loginView.getContext());

        final String url = loginView.getContext().getString(R.string.url_login)+"?username="+username+"&password="+password;
        final String appID= loginView.getContext().getString(R.string.app_id);
        final String key= loginView.getContext().getString(R.string.rest_key);

        Log.i(TAG, "url " + url);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>()
                {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i(TAG, "response "+response.toString());
                        GsonBuilder gsonb = new GsonBuilder();
                        Gson gson = gsonb.create();

                        loginResponse=null;
                        try
                        {
                            loginResponse= gson.fromJson(response.toString(),LoginResponse.class);
                            if(loginResponse!=null)
                            {
                                Log.i(TAG, "loginResponse "+loginResponse.toString());
                                loginView.onRequestSuccess(response);
                            }

                        }catch (Exception e)
                        {
                            loginView.onRequestError(e);
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.i(TAG, "Error: " + error);
                loginView.onRequestError(error);
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Parse-Application-Id", appID);
                params.put("X-Parse-REST-API-Key", key);

                return params;
            }
        };
        queue.add(jsonObjReq);
    }

    public void login(Object object)
    {

    }

    @Override
    public void addView(LoginView view) {
        this.loginView= view;
    }

    @Override
    public void removeView() {
        this.loginView=null;
    }
}
