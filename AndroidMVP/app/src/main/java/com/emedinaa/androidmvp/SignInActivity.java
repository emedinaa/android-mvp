package com.emedinaa.androidmvp;

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
import com.emedinaa.androidmvp.model.entity.UserEntity;
import com.emedinaa.androidmvp.model.entity.request.SignInRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class SignInActivity extends ActionBarActivity {

    private static final String TAG ="SignInActivity" ;
    private EditText eteUsername, eteName, eteLastname, etePassword, eteEmail;
    private View btnSignIn,vLoading;
    private SignInRequest signInRequest;
    private UserEntity userEntity;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        eteUsername= (EditText)findViewById(R.id.eteUsername);
        eteName= (EditText)findViewById(R.id.eteName);
        eteLastname= (EditText)findViewById(R.id.eteLastname);
        etePassword= (EditText)findViewById(R.id.etePassword);
        eteEmail= (EditText)findViewById(R.id.eteEmail);
        btnSignIn= findViewById(R.id.btnSigIn);
        vLoading= findViewById(R.id.vLoading);

        //events
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validar
                /*signInRequest = new SignInRequest();
                signInRequest.setUsername(eteUsername.getText().toString());
                signInRequest.setName(eteName.getText().toString());
                signInRequest.setUsername(eteUsername.getText().toString());
                signInRequest.setLastname(eteLastname.getText().toString());
                signInRequest.setPassword(etePassword.getText().toString());
                signInRequest.setEmail(eteEmail.getText().toString());*/

                userEntity= new UserEntity();
                userEntity.setUsername(eteUsername.getText().toString());
                userEntity.setName(eteName.getText().toString());
                userEntity.setUsername(eteUsername.getText().toString());
                userEntity.setLastname(eteLastname.getText().toString());
                userEntity.setPassword(etePassword.getText().toString());
                userEntity.setEmail(eteEmail.getText().toString());

                signIn();
            }
        });

    }

    private void signIn() {

        vLoading.setVisibility(View.VISIBLE);
        queue = Volley.newRequestQueue(this);

        String url = getString(R.string.url_user);
        Log.i(TAG, "url " + url);

        //JSONObject params= generateJSONObject(signInRequest);
        JSONObject params= generateJSONObject(userEntity);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, params,
                new Response.Listener<JSONObject>()
                {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i("HomeActivity", "response "+response.toString());
                        GsonBuilder gsonb = new GsonBuilder();
                        Gson gson = gsonb.create();

                        UserEntity aux=null;
                        try
                        {
                            aux= gson.fromJson(response.toString(),UserEntity.class);
                            if(aux!=null)
                            {
                                Log.i(TAG, "aux "+aux.toString());
                                userEntity.setObjectId(aux.getObjectId());
                                userEntity.setCreatedAt(aux.getCreatedAt());

                                Log.i(TAG, "userEntity "+userEntity.toString());
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

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Parse-Application-Id", getString(R.string.app_id));
                params.put("X-Parse-REST-API-Key", getString(R.string.rest_key));
                params.put("Content-Type","application/json");

                return params;
            }
        };
        queue.add(jsonObjReq);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return false;
    }

    public  JSONObject generateJSONObject(Object obj)
    {
        Gson gson = new Gson();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(gson.toJson(obj));//JsonObject(gson.toJson(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
