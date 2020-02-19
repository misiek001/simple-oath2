package com.mbor.service;

public abstract class RawService<T> {

    abstract T save(T t);

    abstract T find(Long id);
}
