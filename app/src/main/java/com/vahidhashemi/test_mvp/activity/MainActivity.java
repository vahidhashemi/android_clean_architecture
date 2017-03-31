package com.vahidhashemi.test_mvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vahidhashemi.model.Car;
import com.vahidhashemi.presenter.CarPresenter;
import com.vahidhashemi.test_mvp.App;
import com.vahidhashemi.test_mvp.R;
import com.vahidhashemi.test_mvp.injector.component.ActivityComponent;
import com.vahidhashemi.test_mvp.injector.component.ApplicationComponent;
import com.vahidhashemi.test_mvp.injector.component.DaggerActivityComponent;
import com.vahidhashemi.view.CarView;

import java.util.List;

import javax.inject.Inject;

/**
 * A demonstration of how to implement clean architecture using MVP and Rx
 * Seyed Vahid Hashemi 2017
 * www.vahidhashemi.com
 */
public class MainActivity extends AppCompatActivity implements CarView {

  @Inject
  CarPresenter carPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ApplicationComponent applicationComponent = ((App) getApplication()).getApplicationComponent();
    ActivityComponent activityComponent = DaggerActivityComponent
            .builder()
            .applicationComponent(applicationComponent)
            .build();
    activityComponent.inject(this);
    carPresenter.attachView(this);

  }

  @Override
  protected void onStop() {
    super.onStop();
    carPresenter.onStop();
  }

  @Override
  public void showLoading() {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("Loading data please wait");
      }
    };
    runOnUiThread(runnable);

  }

  @Override
  public void showError() {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("There was an error fix it!");
      }
    };
    runOnUiThread(runnable);
  }

  @Override
  public void showEvent(final List<Car> car) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        for (Car car1 : car) {
          System.out.println(car1.getModel());
        }
      }
    };

    runOnUiThread(runnable);
  }
}
