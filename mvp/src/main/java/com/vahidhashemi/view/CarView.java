package com.vahidhashemi.view;

import com.vahidhashemi.model.Car;
import java.util.List;

public interface CarView extends View {

  void showLoading();
  void showError();
  void showEvent(List<Car> car);
}
