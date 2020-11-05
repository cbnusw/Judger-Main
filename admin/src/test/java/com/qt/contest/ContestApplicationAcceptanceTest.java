package com.qt.contest;

import com.qt.AcceptanceTestUtils;
import com.qt.contest.apply.ContestApplicationRepository;
import com.qt.domain.user.User;
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

import static org.hamcrest.Matchers.greaterThan;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContestApplicationAcceptanceTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContestApplicationRepository contestApplicationRepository;

    private String contestId;

    private String userId;

    private String contestApplicationId;

    private static int id = -1;

    @Test
    //@BeforeEach
    @DisplayName("콘테스트 신청 테스트")
    void setUp() {
        System.out.println("콘테스트 신청-------------------");
        id++;
        System.out.println("유저 생성-------------------");
        User user = new User("2014", String.valueOf(id), "kimhyogeon", "men1210@hanmail.net", "010-9309-3706");
        userId = String.valueOf(userRepository.save(user).getId());

        //콘테스트 생성
        System.out.println("컨테스트 생성-------------------");
        WebTestClient.ResponseSpec responseSpec1 = webTestClient.post()
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

        contestId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec1);

        //콘테스트 신청
        System.out.println("컨테스트 신청-------------------");
        WebTestClient.ResponseSpec responseSpec2 = webTestClient.post()
                .uri("/contests/" + contestId + "/apply/" + userId)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader().valueMatches("location", "/contests/apply/[1-9]+[0-9]*");

        contestApplicationId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec2);
    }

    //질문 left join? 숫자

    @Test
    @DisplayName("콘테스트 신청 전체 조회 테스트")
    void showContestApplications() {
        System.out.println("콘테스트 전체 조회-------------------");
        webTestClient.get()
                .uri("/contests/" + contestId + "/apply")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.length()", greaterThan(1));
    }

    //inner join?
    @Test
    @DisplayName("콘테스트 신청 승인/취소 후 단일 조회 테스트")
    void changeApproveStatus() {
        System.out.println("콘테스트 승인/취소--------------------");
        webTestClient.post()
                .uri("/contests/apply/approve/" + contestApplicationId)
                .exchange()
                .expectStatus()
                .isNoContent();
        System.out.println("콘테스트 단일 조회--------------------");
        webTestClient.get()
                .uri("/contests/apply/" + contestApplicationId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.isApproved").isEqualTo(true);
    }
}
