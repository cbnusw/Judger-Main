package com.qt.user;

import com.qt.domain.user.dto.UserInfo;
import com.qt.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserAcceptanceTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("모든 학생 조회")
    void findAllUsers() {
        System.out.println("모든 학생 조회 테스트-------------------");
        //유저생성1
        UserInfo userInfo1 = UserInfo.builder()
                .userId("2014")
                .name("s1")
                .email("a@b.c")
                .phoneNumber("1234")
                .universityCode("cbnu")
                .build();
        //유저생성1
        UserInfo userInfo2 = UserInfo.builder()
                .userId("2015")
                .name("s2")
                .email("a@b.c")
                .phoneNumber("1234")
                .universityCode("cbnu")
                .build();

        userRepository.save(userInfo1.toEntity());
        userRepository.save(userInfo2.toEntity());

        //모든 유저 조회
        webTestClient.get()
                .uri("/users")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.length()")
                .isEqualTo(2);
    }
}