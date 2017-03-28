package com.ifyou.mvprx.other;

import android.app.Application;

import com.ifyou.mvprx.other.di.AppComponent;
import com.ifyou.mvprx.other.di.DaggerAppComponent;

/**
 * Created by Baranov on 27.03.2017.
 */

public class App extends Application {
    private static AppComponent component;
    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .build();
    }


}