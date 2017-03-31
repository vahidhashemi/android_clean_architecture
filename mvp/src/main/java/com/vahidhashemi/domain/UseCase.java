package com.vahidhashemi.domain;

import rx.Observable;

/**
 * All usecases have to implement this interface
 * @param <T>
 */
public interface UseCase<T>  {
  Observable<T> execute();
}
