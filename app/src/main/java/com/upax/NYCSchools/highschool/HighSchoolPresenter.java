package com.upax.NYCSchools.highschool;

import androidx.lifecycle.ViewModel;

import com.upax.NYCSchools.apimodel.HighSchool;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HighSchoolPresenter implements HighSchoolMvp.Presenter {

    private HighSchoolMvp.View view;
    private HighSchoolMvp.Model model;

    private Disposable subscription = null;

    public HighSchoolPresenter(HighSchoolMvp.Model model){
        this.model = model;
    }

    @Override
    public void loadData() {
        subscription = model.result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ViewModel>() {
                    @Override
                    public void onNext(ViewModel viewModel) {
                        if(view != null){
                            view.updateData(viewModel);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if(view != null){
                            view.showSnackbar("Error al descargar las películas...");
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (view != null){
                            view.showSnackbar("Información descargada con éxito");
                        }
                    }
                });
    }

    @Override
    public void rxJavaUnsubscribe() {
        if (subscription!= null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }


    @Override
    public void setView(HighSchoolMvp.View view) {
            this.view = view;
    }
}
