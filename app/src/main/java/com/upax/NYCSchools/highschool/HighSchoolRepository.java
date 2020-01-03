package com.upax.NYCSchools.highschool;

import android.util.Log;

import com.upax.NYCSchools.apimodel.HighSchool;
import com.upax.NYCSchools.apimodel.ListHighSchool;
import com.upax.NYCSchools.apimodel.Result;
import com.upax.NYCSchools.httpConnection.NYHighSchoolAPI;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class HighSchoolRepository implements Repository{

    public static final String TAG = HighSchoolRepository.class.getSimpleName();
    private NYHighSchoolAPI nyHighSchoolAPI;
    private List<HighSchool> highSchoolList;

    private long lastTimestamp;

    private static final long CACHE_LIFETIME = 20 * 1000;

    public boolean isUpdated(){
        return (System.currentTimeMillis() - lastTimestamp) < CACHE_LIFETIME;
    }

    public HighSchoolRepository(NYHighSchoolAPI nyHighSchoolAPI) {
        this.nyHighSchoolAPI = nyHighSchoolAPI;
        this.lastTimestamp = System.currentTimeMillis();
        this.highSchoolList = new ArrayList<>();
    }

    @Override
    public Observable<HighSchool> getResultFromNetwork() {
        Observable<ListHighSchool> highSchoolObservable = nyHighSchoolAPI.getHighSchools(10)
                /*.concatWith(moviesApiService.getTopMoviesRated(2))
                .concatWith(moviesApiService.getTopMoviesRated(3))*/;

        return highSchoolObservable.concatMap(new Function<ListHighSchool, Observable<HighSchool>>() {
            @Override
            public Observable<HighSchool> apply(ListHighSchool listHighSchool) {
                return Observable.fromIterable(listHighSchool.getHighSchoolList());
            }
        }).doOnNext(new Consumer<HighSchool>() {
            @Override
            public void accept(HighSchool highSchool) {
                highSchoolList.add(highSchool);
                Log.i(TAG, "Name: "+highSchool.getSchoolName());
            }
        });

    }

    @Override
    public Observable<HighSchool> getResultFromCache() {
        return null;
    }

    @Override
    public Observable<HighSchool> getResultData() {
        return getResultFromCache().switchIfEmpty(getResultFromNetwork());
    }

    @Override
    public Observable<String> getCountryFromNetwork() {
        return null;
    }

    @Override
    public Observable<String> getCountryFromCache() {
        return null;
    }

    @Override
    public Observable<String> getCountryData() {
        return null;
    }
}
