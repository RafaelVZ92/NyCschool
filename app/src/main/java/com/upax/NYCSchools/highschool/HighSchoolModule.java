package com.upax.NYCSchools.highschool;

import com.upax.NYCSchools.httpConnection.NYHighSchoolAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HighSchoolModule {
    @Provides
    public HighSchoolMvp.Presenter provideHighSchoolPresenter(HighSchoolMvp.Model schoolModel){
        return new HighSchoolPresenter(schoolModel);
    }

    @Provides
    public HighSchoolMvp.Model provideHighSchoolModel(Repository repository){
        return new HighSchoolModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideHighSchoolRepository(NYHighSchoolAPI nyHighSchoolService){
        return new HighSchoolRepository(nyHighSchoolService);
    }
}
