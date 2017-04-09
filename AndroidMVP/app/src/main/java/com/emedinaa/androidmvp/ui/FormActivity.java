package com.emedinaa.androidmvp.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    /*protected void injectView()
    {
        ButterKnife.bind(this);
    }*/
    protected void showMessage(View container, String message)
    {
        Snackbar snackbar = Snackbar
                .make(container,message, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    protected void next(Bundle bundle, Class<?> activity,boolean destroy) {
        Intent intent= new Intent(this,activity);
        if(bundle!=null){intent.putExtras(bundle);}
        startActivity(intent);
        if(destroy)finish();
    }
}
