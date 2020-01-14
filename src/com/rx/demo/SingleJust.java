package com.rx.demo;

public class SingleJust<T> extends Single<T> {

    private T value;

    public SingleJust(T value) {
        this.value = value;
    }

    @Override
    protected void subscribeActual(SingleObserver<? super T> observer) {
        observer.onSuccess(value);
    }
}
