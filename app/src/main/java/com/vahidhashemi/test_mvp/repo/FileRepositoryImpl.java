package com.vahidhashemi.test_mvp.repo;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vahidhashemi.model.Car;
import com.vahidhashemi.model.ResponseWrapper;
import com.vahidhashemi.repo.DBRepository;
import com.vahidhashemi.test_mvp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * Implementaion of @{@link DBRepository}. this class getting data from
 * res.raw and serialize to a List
 */
public class FileRepositoryImpl implements DBRepository {

  Gson gson;
  Context context;
  String rawData;


  public FileRepositoryImpl(Gson gson, Context context) {
    this.gson = gson;
    this.context = context;
    readFromResource();
  }

  private void readFromResource() {
    InputStream inputStream = context.getResources().openRawResource(R.raw.car);
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String line = null;
    StringBuilder sb = new StringBuilder();

    try {
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
      reader.close();
      inputStream.close();
      rawData = sb.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Override
  public Observable<ResponseWrapper<List<Car>>> getCars() {


    return Observable.defer(new Func0<Observable<ResponseWrapper<List<Car>>>>() {
      @Override
      public Observable<ResponseWrapper<List<Car>>> call() {
        ResponseWrapper<List<Car>> responseWrapper = new ResponseWrapper<>();
        responseWrapper.body = gson.fromJson(rawData, new TypeToken<List<Car>>(){}.getType());
        return Observable.just(responseWrapper);
      }
    });
//    responseWrapper.body = gson.fromJson(rawData, new TypeToken<List<Car>>(){}.getType());
//    return Observable.just(responseWrapper);
  }
}
