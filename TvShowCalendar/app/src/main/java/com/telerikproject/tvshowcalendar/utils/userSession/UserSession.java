package com.telerikproject.tvshowcalendar.utils.userSession;

import android.content.SharedPreferences;

import com.telerikproject.tvshowcalendar.utils.userSession.base.IUserSession;

import javax.inject.Inject;

public class UserSession implements IUserSession {

    private final SharedPreferences sharedPreferences;

    @Inject
    public UserSession(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public String getUsername() {
        String username = this.sharedPreferences.getString("username", null);
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.sharedPreferences.edit().putString("username", username).apply();
    }

    @Override
    public boolean isUserLoggedIn() {
        String username = getUsername();
        return username != null;
    }

    @Override
    public void clearSession() {
        setUsername(null);
    }
}
