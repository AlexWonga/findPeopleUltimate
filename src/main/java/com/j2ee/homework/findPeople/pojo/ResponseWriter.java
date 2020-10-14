//package com.j2ee.homework.findPeople.pojo;
//
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import java.util.Objects;
//import com.j2ee.homework.findPeople.pojo.ResponseBody;

//@ControllerAdvice
//public class ResponseWriter implements ResponseBodyAdvice{
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class aClass) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
////        if(Objects.isNull(o)) {
////            ResponseBody.builder().statusCode(200).msg("success").data(o).build();
////        }
////        if(o instanceof ResponseBody){
////            return o;
////        }
////        return o
//        return o;
//    }
//}