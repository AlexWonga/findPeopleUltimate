package com.j2ee.homework.findPeople.controller;

import lombok.Data;

@Data
public class ResponseBody<T>{
    public boolean isSuccessful;
    public String message;
    public T data;

    public ResponseBody(boolean isSuccessful, String message, T data) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.data = data;
    }
}
