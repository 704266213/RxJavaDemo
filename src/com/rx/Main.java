package com.rx;

import com.rx.demo.Disposable;
import com.rx.demo.Function;
import com.rx.demo.Single;
import com.rx.demo.SingleObserver;

public class Main {

    public static void main(String[] args) {
        Single.just("123")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String value) throws Exception {
                        System.out.println("map : " + value);
                        return "jaty";
                    }
                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String value) {
                        System.out.println("value : " + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("==========onError===========" );
                    }
                });
    }
}
