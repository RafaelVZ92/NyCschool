package com.upax.NYCSchools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.ViewGroup;

import com.upax.NYCSchools.apimodel.HighSchool;
import com.upax.NYCSchools.highschool.HighSchoolMvp;
import com.upax.NYCSchools.root.App;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements HighSchoolMvp.View{

    private final String TAG = MainActivity.class.getSimpleName();


    @Inject
    HighSchoolMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    public void updateData(ViewModel viewModel) {

    }

    @Override
    public void showSnackbar(String s) {

    }
}
