package com.qt.start;

import com.qt.AcceptanceTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContestStartAcceptanceTest {
    @Autowired WebTestClient webTestClient;
    @DisplayName("콘테스트 시작 테스트")
    @Test
    void startContest(){
        System.out.println("콘테스트 등록 테스트");
        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/contests")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("name", "홍길동")
                        .with("description", "easy contests")
                        .with("startTime", "2020-10-30T15:27:25.092046")
                        .with("endTime", "2020-10-30T15:54:25.092046"))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader().valueMatches("location", "/contests/[1-9]+[0-9]*");

        String contestId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec);

        System.out.println("콘테스트 시작 테스트");
        responseSpec=webTestClient.post()
                .uri("/start/contest/"+contestId)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("time", String.valueOf(LocalDateTime.now())))
                .exchange()
                .expectStatus()
                .isOk();

    }
}
