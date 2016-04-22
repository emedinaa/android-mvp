package com.emedinaa.androidmvp.ui;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emedinaa.androidmvp.R;
import com.emedinaa.androidmvp.model.entity.User;
import com.emedinaa.androidmvp.ui.listeners.OnFragmentListener;


public class MainActivity extends ActionBarActivity implements OnFragmentListener {

    private TextView tviUsername;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extras();

        tviUsername= (TextView)findViewById(R.id.tviUsername);
        tviUsername.setText("Bienvenido " + "");
    }

    private void extras() {

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                user= (User)bundle.getSerializable("ENTITY");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }


}
