package com.rx.demo;

import com.sun.istack.internal.NotNull;

public interface SingleSource<T> {

    void subscribe(SingleObserver<T> singleObserver);

}
