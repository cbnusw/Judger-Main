package com.qt.contest;

import com.qt.AcceptanceTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.greaterThan;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "360000") //Timeout을 15초로 설정 이상있으면 지울 것
public class ContestAcceptanceTest {

    @Autowired
    private WebTestClient webTestClient;

    private String contestId;

    @BeforeEach
    @DisplayName("콘테스트 등록 테스트")
    void createContest() {
        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/contests")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("name", "contest1")
                        .with("description", "easy contests")
                        .with("activeTime", String.valueOf(LocalDateTime.now()))
                        .with("inActiveTime", String.valueOf(LocalDateTime.now()))
                        .with("startTime", String.valueOf(LocalDateTime.now()))
                        .with("endTime", String.valueOf(LocalDateTime.now()))
                        .with("freezeTime", String.valueOf(LocalDateTime.now()))
                        .with("unFreezeTime", String.valueOf(LocalDateTime.now())))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader().valueMatches("location", "/contests/[1-9]+[0-9]*");

        contestId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec);
    }

    @Test
    @DisplayName("콘테스트 전체 조회 테스트")
    void showAllContest() {
        webTestClient.get()
                .uri("/contests")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.length()", greaterThan(1));
    }

    @Test
    @DisplayName("콘테스트 조회 테스트")
    void showContest() {
        webTestClient.get()
                .uri("/contests/" + contestId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("contest1");
    }

    @Test
    @DisplayName("콘테스트 수정 테스트")
    void updateContest() {
        webTestClient.post()
                .uri("/contests/" + contestId)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("name", "update contest")
                        .with("description", "easy contests")
                        .with("activeTime", String.valueOf(LocalDateTime.now()))
                        .with("inActiveTime", String.valueOf(LocalDateTime.now()))
                        .with("startTime", String.valueOf(LocalDateTime.now()))
                        .with("endTime", String.valueOf(LocalDateTime.now()))
                        .with("freezeTime", String.valueOf(LocalDateTime.now()))
                        .with("unFreezeTime", String.valueOf(LocalDateTime.now())))
                .exchange()
                .expectStatus()
                .isNoContent();

        webTestClient.get()
                .uri("/contests/" + contestId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("update contest");
    }

    @Test
    @DisplayName("콘테스트 삭제 테스트")
    void deleteContest() {
        webTestClient.delete()
                .uri("/contests/" + contestId)
                .exchange()
                .expectStatus()
                .isNoContent();

        webTestClient.get()
                .uri("/contests/" + contestId)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    @DisplayName("콘테스트에 문제 추가 테스트")
    void registerProblem() {
        //POST problem1을 저장
        String problemId1 = createProblem("test1");

        //POST problem2을 저장
        String problemId2 = createProblem("test2");

        //POST contest에 problem 2개 추가
        webTestClient.post()
                .uri("/contests/" + contestId + "/problems")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("problemIds", problemId1)
                        .with("problemIds", problemId2))
                .exchange()
                .expectStatus()
                .isNoContent();
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
