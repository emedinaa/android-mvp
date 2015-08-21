package com.emedinaa.androidmvp.view;

import android.content.Context;

/**
 * Created by emedinaa on 21/08/15.
 */
public interface LoginView {

    void showLoading(boolean state);
    void onRequestSuccess(Object object);
    void onRequestError(Object object);

    Context getContext();
}
