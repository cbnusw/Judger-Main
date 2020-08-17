//package com.qt.submit;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.netty.handler.codec.http.HttpMethod;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.HttpServerErrorException;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.HashMap;
//
//@RestController
//public class SubmitController {
//
//    private final SubmitService submitService;
//
//    public SubmitController(SubmitService submitService){
//        this.submitService=submitService;
//    }
//
//    @GetMapping("/GetkobisData")
//    public String callAPI() throws JsonProcessingException {
//
//        HashMap<String, Object> result = new HashMap<String, Object>();
//
//        String jsonInString = "";
//
//        try {
//
//            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//            factory.setConnectTimeout(5000); //타임아웃 설정 5초
//            factory.setReadTimeout(5000);//타임아웃 설정 5초
//            RestTemplate restTemplate = new RestTemplate(factory);
//
//            HttpHeaders header = new HttpHeaders();
//            HttpEntity<?> entity = new HttpEntity<>(header);
//
//            String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
//
//            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"key=430156241533f1d058c603178cc3ca0e&targetDt=20120101").build();
//
//            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
//            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
//            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
//            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
//            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
//
//            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
//            ObjectMapper mapper = new ObjectMapper();
//            jsonInString = mapper.writeValueAsString(resultMap.getBody());
//
//        } catch (HttpClientErrorException | HttpServerErrorException e) {
//            result.put("statusCode", e.getRawStatusCode());
//            result.put("body"  , e.getStatusText());
//            System.out.println("dfdfdfdf");
//            System.out.println(e.toString());
//
//        } catch (Exception e) {
//            result.put("statusCode", "999");
//            result.put("body"  , "excpetion오류");
//            System.out.println(e.toString());
//        }
//
//        return jsonInString;
//
//    }
//
//
////    private ClientHttpRequestFactory getClientHttpRequestFactory(){
////        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
////
////        clientHttpRequestFactory.setConnectionRequestTimeout(5000);
////        clientHttpRequestFactory.setReadTimeout(5000);
////
////        return clientHttpRequestFactory;
////    }
///*
//
//    UriComponents uri= UriComponentsBuilder.newInstance()
//                               .scheme("https")
//                               .host("localhost:8080")
//                               .path("/api/judge")
//                               .build();
//*/
//
//
//
//}
