package com.emedinaa.androidmvp.presenter;

/**
 * Created by emedinaa on 16/04/16.
 */
public interface Presenter<T> {

    void addView(T view);
    void removeView();
}
