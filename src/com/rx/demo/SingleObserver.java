package com.rx.demo;

public interface SingleObserver<T> {

    void onSubscribe(Disposable d);

    void onSuccess(T t);

    void onError(Throwable e);


}
