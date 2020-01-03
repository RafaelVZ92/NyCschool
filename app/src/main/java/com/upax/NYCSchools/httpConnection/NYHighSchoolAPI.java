package com.upax.NYCSchools.httpConnection;

import com.upax.NYCSchools.apimodel.HighSchool;
import com.upax.NYCSchools.apimodel.ListHighSchool;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NYHighSchoolAPI {

    @GET("s3k6-pzi2.json")
    Observable<ListHighSchool> getHighSchools(@Query("$limit") Integer limit);
}
