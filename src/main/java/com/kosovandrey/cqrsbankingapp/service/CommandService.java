package com.kosovandrey.cqrsbankingapp.service;

public interface CommandService<T> {

    void create(T object);

}
