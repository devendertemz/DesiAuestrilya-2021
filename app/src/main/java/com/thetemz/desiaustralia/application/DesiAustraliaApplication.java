package com.thetemz.desiaustralia.application;

import android.app.Application;
import android.content.Context;

import com.thetemz.desiaustralia.retrofit.RetrofitHelper;

public class DesiAustraliaApplication extends Application {
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        RetrofitHelper.getInstance().init(context);
    }
}
