package com.byteshaft.registerlogintest;

import android.app.Application;
import android.content.Context;

public class AppGlobals extends Application {

    private static Context sContext;
    public static final String LOGIN_URL = "login_url";
    public static final String REGISTER_URL = "register_url";

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

    }

    public static Context getContext(){
     return sContext;
    }
}
