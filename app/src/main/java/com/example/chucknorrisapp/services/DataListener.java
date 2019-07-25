package com.example.chucknorrisapp.services;

public interface DataListener<T> {

    void onDataReceived(T data);

    void onDataError(String message);
}
