package com.rx.demo;

public class SingleMap<T, R> extends Single<T> {

    private Single<T> single;
    private Function<T, R> mapper;

    public SingleMap(Single<T> single, Function<T, R> mapper) {
        super();
        this.single = single;
        this.mapper = mapper;
    }

    @Override
    protected void subscribeActual(SingleObserver<? super T> observer) {
        single.subscribeActual(new MapSingleObserver(observer, mapper));
    }


    private class MapSingleObserver<T, R> implements SingleObserver<T> {

        final SingleObserver<? super R> observer;
        private Function<T, R> mapper;

        public MapSingleObserver(SingleObserver<? super R> observer, Function<T, R> mapper) {
            this.observer = observer;
            this.mapper = mapper;
        }

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onSuccess(T t) {
            R r = null;
            try {
                r = mapper.apply(t);
            } catch (Exception e) {
                onError(e);
                e.printStackTrace();
                return;
            }
            observer.onSuccess(r);
        }

        @Override
        public void onError(Throwable e) {
            observer.onError(e);
        }
    }
}
