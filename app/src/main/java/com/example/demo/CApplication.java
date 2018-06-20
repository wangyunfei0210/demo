package com.example.demo;

import android.app.Application;

public class CApplication extends Application {
    private static CApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static CApplication getInstance() {
        return instance;
    }
}
