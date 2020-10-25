//package com.qt.homework;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.web.reactive.function.BodyInserters;
//
//import java.time.LocalDateTime;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class HomeworkAcceptanceTest {
//
//
//    private WebTestClient webTestClient;
//    private String homeworkId;
//
//    @BeforeEach
//    @DisplayName("Homework Register Test")
//    void createHomework() {
//        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
//                                             .uri("/homeworks")
//                                             .contentLength(MediaType.MULTIPART_FORM_DATA)
//                                             .body(BodyInserters.fromFormData("name", "homework1")
//                                                           .with())
//                                             .exchange()
//                                             .expectStatus()
//                                             .isCreated()
//                                             .expectHeader().valueMatches("location", "/contests/[1-9]+[0-9]*");
//
//        homeworkId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec);
//
//    }
//
//
//}