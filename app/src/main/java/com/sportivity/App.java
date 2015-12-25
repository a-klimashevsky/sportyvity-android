package com.sportivity;

import android.app.Application;

import com.bettervectordrawable.Convention;
import com.bettervectordrawable.VectorDrawableCompat;
import com.facebook.FacebookSdk;
import com.sportivity.web.Server;

/**
 * Created by Alex Klimashevsky on 13.12.2015.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Server.init(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}