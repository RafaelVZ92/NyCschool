package com.upax.NYCSchools.highschool;

import com.upax.NYCSchools.apimodel.HighSchool;
import com.upax.NYCSchools.apimodel.ListHighSchool;

import io.reactivex.Observable;

public interface Repository {

    Observable<HighSchool> getResultFromNetwork();
    Observable<HighSchool> getResultFromCache();
    Observable<HighSchool> getResultData();

    Observable<String> getCountryFromNetwork();
    Observable<String> getCountryFromCache();
    Observable<String> getCountryData();
    
}
