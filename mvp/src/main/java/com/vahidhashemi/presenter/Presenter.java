package com.vahidhashemi.presenter;

import com.vahidhashemi.view.View;

/**
 * Created by vahid on 3/28/17.
 */

public interface Presenter<T extends View> {
  void onCreate();
  void onStop();
  void onStart();
  void onPause();
  void attachView(T view);


}
