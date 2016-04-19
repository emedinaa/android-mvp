package com.emedinaa.androidmvp.view;

import android.content.Context;

/**
 * Created by emedinaa on 21/08/15.
 */
public interface LoginView  extends BaseView{

    void showLoading(boolean state);
    void onRequestSuccess(Object object);
    void onRequestError(Object object);

    void showLoading();
    void hideLoading();

}
