package com.qt.contest;

import com.qt.AcceptanceTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContestProblemRegistrationAcceptanceTest {

    @Autowired
    private WebTestClient webTestClient;

    private String contestId;

    private String problemId1;

    private String problemId2;



    @DisplayName("콘테스트에 문제 추가 테스트")
    //@BeforeEach
    @Test
    void createContest() {
        System.out.println("콘테스트 문제 추가--------------------");

        System.out.println("콘테스트 등록--------------------");
        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/contests")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("name", "contest1")
                        .with("description", "easy contests")
                        .with("startTime", String.valueOf(LocalDateTime.now()))
                        .with("endTime", String.valueOf(LocalDateTime.now())))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader().valueMatches("location", "/contests/[1-9]+[0-9]*");

        contestId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec);


        //POST problem1을 저장
        System.out.println("콘테스트 문제1 만들기");
        problemId1 = createProblem("test1");

        //POST problem2을 저장
        System.out.println("콘테스트 문제2 만들기");
        problemId2 = createProblem("test2");

        //POST contest에 problem 2개 추가
        System.out.println("콘테스트에 문제1,2 추가");
       webTestClient.post()
                .uri("/contests/" + contestId + "/problems")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("problemIds", problemId1)
                        .with("problemIds", problemId2))
                .exchange()
                .expectStatus()
                .isNoContent();
    }

    @Test
    @DisplayName("콘테스트에 등록된 문제 조회 테스트")
    void showRegisteredProblems() {
        System.out.println("콘테스트에 등록된 문제 조회");
        webTestClient.get()
                .uri("/contests/" + contestId + "/problems")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(2);
    }



    private String createProblem(String test1) {
        ByteArrayResource file1 = new ByteArrayResource(new byte[]{1, 2, 3}) {
            @Override
            public String getFilename() {
                return "test.pdf";
            }
        };

        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/problems")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("file", file1)
                        .with("name", test1)
                        .with("timeLimit", 1d)
                        .with("memoryLimit", 1d))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader().valueMatches("Location", "/problems/[1-9]+[0-9]*");

        return AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec);
    }
}
