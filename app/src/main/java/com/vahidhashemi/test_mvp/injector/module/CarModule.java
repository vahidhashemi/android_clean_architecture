package com.vahidhashemi.test_mvp.injector.module;

import com.vahidhashemi.domain.FetchCarUsecase;
import com.vahidhashemi.presenter.CarPresenter;
import com.vahidhashemi.repo.DBRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class CarModule {


    @Provides
    public FetchCarUsecase fetchCarUsecase(DBRepository repository) {
        return new FetchCarUsecase(repository);
    }

    @Provides
    public CarPresenter car(FetchCarUsecase fetchCarUsecase) {
        return new CarPresenter(fetchCarUsecase);
    }


}
