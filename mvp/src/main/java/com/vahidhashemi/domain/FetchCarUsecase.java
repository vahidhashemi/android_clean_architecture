package com.vahidhashemi.domain;

import com.vahidhashemi.model.Car;
import com.vahidhashemi.model.ResponseWrapper;
import com.vahidhashemi.repo.DBRepository;
import java.util.List;
import rx.Observable;

public class FetchCarUsecase implements UseCase<ResponseWrapper<List<Car>>>  {

  DBRepository repository;
  public FetchCarUsecase(DBRepository repository) {
    this.repository = repository;
  }

  @Override
  public Observable<ResponseWrapper<List<Car>>> execute() {
    return repository.getCars();
  }
}
