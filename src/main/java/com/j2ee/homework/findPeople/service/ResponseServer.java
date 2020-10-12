package com.j2ee.homework.findPeople.service;

import lombok.Data;

/**
 * @author wong
 */
@Data
public class ResponseServer<T> {
    public boolean isSuccessful;
    public String message;
    public T data;

    public ResponseServer(boolean isSuccessful, String message, T data) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.data = data;
    }
}
