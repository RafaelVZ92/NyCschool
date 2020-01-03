package com.upax.NYCSchools.highschool;

import io.reactivex.Observable;

public interface HighSchoolMvp {

    interface View{
        void updateData(androidx.lifecycle.ViewModel viewModel);

        void showSnackbar(String s);
    }

    interface Presenter{
        void loadData();

        void rxJavaUnsubscribe();

        void setView(HighSchoolMvp.View view);
    }

    interface Model {
        Observable<ViewModel> result();
    }
}
