package com.emedinaa.androidmvp.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.emedinaa.androidmvp.model.entity.User;
import butterknife.Bind;


public class MainActivity extends FormActivity {

    @Bind(R.id.tviUsername)
    TextView tviUsername;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extras();
        injectView();
        ui();
    }

    private void ui() {
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
