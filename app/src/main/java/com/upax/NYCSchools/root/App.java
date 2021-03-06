package com.upax.NYCSchools.root;

import android.app.Application;

import com.upax.NYCSchools.highschool.HighSchoolModule;
import com.upax.NYCSchools.httpConnection.NyHighSchoolApiModule;


public class App extends Application {

    private ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .highSchoolModule(new HighSchoolModule())
                .nyHighSchoolApiModule(new NyHighSchoolApiModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
