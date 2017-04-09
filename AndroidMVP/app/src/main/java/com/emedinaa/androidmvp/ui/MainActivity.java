package com.emedinaa.androidmvp.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.emedinaa.androidmvp.model.entity.User;



public class MainActivity extends FormActivity {

    private TextView tviUsername;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extras();
        ui();
    }

    private void ui() {
        tviUsername= (TextView) findViewById(R.id.tviUsername);
        tviUsername.setText("Welcome " + user.getFirstname()+" "+user.getLastname());
    }

    private void extras() {
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                user= (User)bundle.getParcelable("ENTITY");
            }
        }
    }
}
