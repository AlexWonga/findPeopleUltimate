package com.j2ee.homework.findPeople.dao;

import lombok.Data;

@Data
public class ResponseDB<T> {
    boolean isSuccessful;
    String message;
    T data;

    public ResponseDB(boolean isSuccessful, String message, T data) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.data = data;
    }
}
