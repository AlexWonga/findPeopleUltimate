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
}
