package com.vahidhashemi.repo;

import com.vahidhashemi.model.Car;
import com.vahidhashemi.model.ResponseWrapper;

import java.util.List;
import rx.Observable;

public interface DBRepository {
  Observable<ResponseWrapper<List<Car>>> getCars();
}
