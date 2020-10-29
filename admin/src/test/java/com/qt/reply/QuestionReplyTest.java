package com.qt.reply;

import com.qt.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionReplyTest {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("콘테스트 질문 답변 or 답변 수정 테스트")
    void replyQuestion(){
        System.out.println("콘테스트 답변 등록 테스트");
        WebTestClient.ResponseSpec responseSpec=webTestClient.post()
                .uri("/question/6/reply")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("reply", "answer"))
                .exchange()
                .expectStatus()
                .isNoContent();
    }

    @Test
    @DisplayName("콘테스트 질문 답변 삭제 테스트")
    void deleteQuestion(){
        System.out.println("콘테스트 답변 삭제 테스트");
        WebTestClient.ResponseSpec responseSpec=webTestClient.delete()
                .uri("/question/6/reply/delete")
                .exchange()
                .expectStatus()
                .isNoContent();
    }
}
