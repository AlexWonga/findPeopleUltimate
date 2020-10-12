package com.j2ee.homework.findPeople.dao.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private int statusCode;
    private String message;
    private Object data;

    public final static int SUCCESS = 200;
    public final static int SERVER_ERROR = 500;
    public final static int CLIENT_ERROR = 400;
}
