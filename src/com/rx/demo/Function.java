package com.rx.demo;

public interface Function<T, R> {

    R apply(T t) throws Exception;
}
