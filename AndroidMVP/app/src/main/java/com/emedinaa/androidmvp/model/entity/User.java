package com.emedinaa.androidmvp.model.entity;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emedinaa on 19/05/2015.
 */
public class User implements Parcelable {
    private String id;
    private String username;
    private String firstname;
    private String lastname;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.username);
        dest.writeString(this.firstname);
        dest.writeString(this.lastname);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readString();
        this.username = in.readString();
        this.firstname = in.readString();
        this.lastname = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
