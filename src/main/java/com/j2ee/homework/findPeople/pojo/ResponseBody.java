package com.j2ee.homework.findPeople.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseBody<T>{
    int statusCode;
    String msg;
    T data;

    public final static int SUCCESS = 200;
    public final static int SERVER_ERROR = 500;
    public final static int CLIENT_ERROR = 400;
}
