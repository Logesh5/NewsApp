package com.example.logesh.ny.Singleton;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by logesh on 08-04-2016.
 */
public class MyApplication extends Application {
    private static  MyApplication myApp;


    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);
        myApp = this;
    }

    public static MyApplication getAppInstance(){
        return myApp;
    }

    public  static Context getContext(){
        return myApp.getApplicationContext();
    }


}
