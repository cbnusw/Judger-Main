package com.qt.question;

import com.qt.AcceptanceTestUtils;
import com.qt.repository.QuestionRepository;
import com.qt.contest.ContestRepository;
import com.qt.domain.contest.Contest;
import com.qt.domain.contest.dto.ContestInfo;
import org.junit.jupiter.api.BeforeEach;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuestionAcceptanceTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ContestRepository contestRepository;

    //@Autowired
    //private StudentRepository studentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private String questionId;

    //@Test
    @BeforeEach
    @DisplayName("콘테스트 질문 등록 테스트")
    void createContest() throws Exception {
        System.out.println("콘테스트 질문 등록 테스트----");

        System.out.println("콘테스트 생성 ");

        ContestInfo contestInfo = ContestInfo.builder()
                .name("contest 1")
                .description("easy contest")
                .activeTime(LocalDateTime.now())
                .inActiveTime(LocalDateTime.now())
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .freezeTime(LocalDateTime.now())
                .unFreezeTime(LocalDateTime.now())
                .build();

        Contest contest = contestRepository.save(contestInfo.toEntity());


        System.out.println("콘테스트 질문 등록 ");
        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/contests/"+ contest.getId() +"/questions")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("content", "test")
                        .with("createTime", String.valueOf(LocalDateTime.now()))
                        .with("problemNumber", String.valueOf(1))
                        .with("reply","response")
                        )
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader().valueMatches("location", "/questions/[1-9]+[0-9]*");

        questionId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec);
        System.out.println("Question Id :" + questionId);
    }

    @Test
    @DisplayName("질문 조회 테스트")
    void showQuestion() {
        System.out.println("콘테스트 질문 조회 테스트");
        webTestClient.get()
                .uri("/questions/" + questionId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.content").isEqualTo("test");
    }

    @Test
    @DisplayName("질문 전체 조회 테스트")
    void showAllQuestion(){
        System.out.println("콘테스트 질문 전체 조회 테스트");
        webTestClient.get()
                .uri("/questions")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody();

    }
}