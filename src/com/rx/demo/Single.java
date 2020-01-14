package com.rx.demo;

public abstract class Single<T> implements SingleSource<T> {


    public static final <T> Single<T> just(T t) {
        return new SingleJust(t);
    }

    public final <R> Single<R> map(Function<T,R> mapper) {
        return new SingleMap(this, mapper);
    }

    protected abstract void subscribeActual(SingleObserver<? super T> observer);


    @Override
    public void subscribe(SingleObserver<T> singleObserver) {
        subscribeActual(singleObserver);
    }
}
