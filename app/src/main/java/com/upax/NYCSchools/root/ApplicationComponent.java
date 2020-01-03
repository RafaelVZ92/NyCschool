package com.upax.NYCSchools.root;

import com.upax.NYCSchools.MainActivity;
import com.upax.NYCSchools.highschool.HighSchoolModule;
import com.upax.NYCSchools.httpConnection.NyHighSchoolApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, HighSchoolModule.class, NyHighSchoolApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);
}
