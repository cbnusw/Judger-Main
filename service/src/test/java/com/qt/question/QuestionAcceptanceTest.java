package com.qt.question;

import com.qt.AcceptanceTestUtils;
import com.qt.contest.ContestRepository;
import com.qt.domain.contest.Contest;
import com.qt.domain.contest.dto.ContestInfo;
import com.qt.user.UserRepository;
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

    //StudentRepository=> UserRepository로 변경
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private String questionId;

    @BeforeEach
    @DisplayName("콘테스트 질문 등록 테스트")
    void createContest() throws Exception {

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

        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/contests/"+ contest.getId() +"/questions")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("content", "test")
                        //.with("createTime", String.valueOf(LocalDateTime.now()))
                        .with("problemNumber", String.valueOf(1))
                        .with("response", " "))
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
        webTestClient.get()
                .uri("/questions/" + questionId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.content").isEqualTo("test");
    }
}