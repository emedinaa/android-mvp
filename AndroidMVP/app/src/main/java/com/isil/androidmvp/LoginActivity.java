package com.isil.androidmvp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.isil.androidmvp.model.entity.response.LoginResponse;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends ActionBarActivity {

    private static final String TAG = "HomeActivity";
    private EditText eteUsername,etePassword;
    private View btnLogin,vLoading,tviSignIn;

    private String username, password;

    private RequestQueue queue;
    private LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eteUsername = (EditText)findViewById(R.id.eteUsername);
        etePassword = (EditText)findViewById(R.id.etePassword);
        btnLogin = findViewById(R.id.btnLogin);
        vLoading = findViewById(R.id.vLoading);
        tviSignIn = findViewById(R.id.tviSignIn);

        //events
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //validate
                if(validate())
                {
                    //ir al servidor
                    login();
                }
            }
        });
        tviSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSignIn();
            }
        });
        vLoading.setVisibility(View.GONE);
    }

    private boolean validate() {

        username = eteUsername.getText().toString().trim();
        password = etePassword.getText().toString().trim();

        eteUsername.setError(null);
        etePassword.setError(null);
        if(username.isEmpty())
        {
            eteUsername.setError("Ingresar este campo");
            return false;
        }
        if(password.isEmpty())
        {
            etePassword.setError("Ingresar este campo");
            return false;
        }
        return true;
    }

    private void gotoSignIn() {
        startActivity(new Intent(this,SignInActivity.class));
        //finish();
    }

    private void login()
    {

        vLoading.setVisibility(View.VISIBLE);
        queue = Volley.newRequestQueue(this);

        String url = getString(R.string.url_login)+"?username="+username+"&password="+password;
        Log.i("HomeActivity", "url "+url);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>()
                {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i("HomeActivity", "response "+response.toString());
                        GsonBuilder gsonb = new GsonBuilder();
                        Gson gson = gsonb.create();

                        loginResponse=null;
                        try
                        {
                            loginResponse= gson.fromJson(response.toString(),LoginResponse.class);
                            if(loginResponse!=null)
                            {
                                Log.i(TAG, "loginResponse "+loginResponse.toString());

                                gotoHome();
                            }

                        }catch (Exception e)
                        {

                        }
                        vLoading.setVisibility(View.GONE);

                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.i("HomeActivity", "Error: " + error.getMessage());
                // hide the progress dialog

                vLoading.setVisibility(View.GONE);

            }
        })
        {
            /*@Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //return super.getParams();

                Map<String,String> nParams = new HashMap<String, String>();
                for (int i = 0; i <params.size() ; i++)
                {
                    nParams.put(params.get(i).getName(), params.get(i).getValue());
                }
                Log.d(TAG, "POST params " + nParams.toString());
                return nParams;
            }*/

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Parse-Application-Id", getString(R.string.app_id));
                params.put("X-Parse-REST-API-Key", getString(R.string.rest_key));


                return params;
            }
        };
        queue.add(jsonObjReq);
    }

    private void gotoHome() {

       startActivity(new Intent(this,MainActivity.class));
       finish();
    }

    /*

    https://api.parse.com/1/login?username=emedinaa&password=123456
        {
            "createdAt": "2015-05-19T20:11:22.931Z",
            "objectId": "fSVL0hhKgc",
            "sessionToken": "r:PxcekgeZiG3afFZGArdZdQ54w",
            "updatedAt": "2015-05-19T20:30:00.793Z",
            "username": "emedinaa"
        }
     */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return false;
    }
}
