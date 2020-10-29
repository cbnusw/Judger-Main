package com.qt.contest;

import com.qt.AcceptanceTestUtils;
import com.qt.domain.contest.Contest;
import com.qt.domain.contest.dto.ContestInfo;
import com.qt.domain.user.User;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.assertj.core.api.Assertions;
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
import com.qt.user.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContestAcceptanceTest {

    @Autowired
    private WebTestClient webTestClient;

    private String contestId;

//+
    @Autowired
    private ContestService contestService;

//+


    @DisplayName("콘테스트 등록 테스트")
    @Test
    //@BeforeEach
    void createContest() {
        System.out.println("콘테스트 등록 테스트");
        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/contests")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("name", "홍길동")
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



        //System.out.println(contestId);
    }


    @Test
    @Ignore
    @DisplayName("콘테스트 전체 조회 테스트")
    void showAllContest() {
        System.out.println("콘테스트 전체 조회 테스트");
        webTestClient.get()
                .uri("/contests")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.length()", greaterThan(1));
    }

    @Test
    @Ignore
    @DisplayName("콘테스트 조회 테스트")
    void showContest() {
        System.out.println("콘테스트 조회 테스트");
        System.out.println("콘테스트 id: "+contestId);
        webTestClient.get()
                .uri("/contests/" + contestId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("contest1");
    }

    //질문 select? 숫자?
    @Test
    @Ignore
    @DisplayName("콘테스트 수정 테스트")
    void updateContest() {
        System.out.println("콘테스트 수정 테스트");
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

        System.out.println("콘테스트 수정후 조회 테스트");
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
        System.out.println("콘테스트 삭제 테스트");
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
        System.out.println("콘테스트 문제 추가 테스트");
        //POST problem1을 저장
        System.out.println("콘테스트 problem1 저장 테스트");
        String problemId1 = createProblem("test1");

        //POST problem2을 저장
        System.out.println("콘테스트 problem2 저장 테스트");
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
