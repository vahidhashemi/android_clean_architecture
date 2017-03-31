package com.vahidhashemi.presenter;

import com.vahidhashemi.domain.FetchCarUsecase;
import com.vahidhashemi.model.Car;
import com.vahidhashemi.model.ResponseWrapper;
import com.vahidhashemi.view.CarView;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class CarPresenter implements Presenter<CarView> {
  private Subscription getCarSubscription;
  private CarView showCar;
  private FetchCarUsecase fetchCarUsecase;

  public CarPresenter(FetchCarUsecase fetchCarUsecase) {
    this.fetchCarUsecase = fetchCarUsecase;
  }

  @Override
  public void onCreate() {

  }

  @Override
  public void onStop() {
    if (getCarSubscription != null && !getCarSubscription.isUnsubscribed())
      getCarSubscription.unsubscribe();
  }

  @Override
  public void onStart() {

  }

  @Override
  public void onPause() {

  }

  @Override
  public void attachView(CarView view) {
    this.showCar = view;
    getCars();
  }

  private void getCars() {
    showCar.showLoading();
    getCarSubscription = fetchCarUsecase.execute()
            .subscribeOn(Schedulers.io())
            .onErrorReturn(new Func1<Throwable, ResponseWrapper<List<Car>>>() {
              @Override
              public ResponseWrapper<List<Car>> call(Throwable throwable) {
                throwable.printStackTrace();
                showCar.showError();
                return null;
              }
            })
            .subscribe(new Action1<ResponseWrapper<List<Car>>>() {
              @Override
              public void call(ResponseWrapper<List<Car>> listResponseWrapper) {
                showCar.showEvent(listResponseWrapper.body);
              }
            });
  }


}
