//package com.qt.submit;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class SubmitController {
//    private final SubmitService submitService;
//
//    private ClientHttpRequestFactory getClientHttpRequestFactory(){
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
//
//        clientHttpRequestFactory.setConnectionRequestTimeout(5000);
//        clientHttpRequestFactory.setReadTimeout(5000);
//
//        return clientHttpRequestFactory;
//    }
//
//}
