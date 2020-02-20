package com.mbor.service;

public interface IService<T> {

    T save(T t);

    T find(Long id);

}
