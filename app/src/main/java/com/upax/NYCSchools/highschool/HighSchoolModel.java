package com.upax.NYCSchools.highschool;

import com.upax.NYCSchools.apimodel.ListHighSchool;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class HighSchoolModel implements HighSchoolMvp.Model {

    private Repository repository;

    public HighSchoolModel(Repository repository){
        this.repository = repository;
    }


    @Override
    public Observable<ViewModel> result() {
       return null;
    }
}
