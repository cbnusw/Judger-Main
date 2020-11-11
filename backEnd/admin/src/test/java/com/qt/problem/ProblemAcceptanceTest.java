package com.qt.problem;

import com.qt.AcceptanceTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.Duration;

import static org.hamcrest.Matchers.greaterThan;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "360000") //Timeout을 15초로 설정
public class ProblemAcceptanceTest {

    @Autowired
    private WebTestClient webTestClient;

    private String problemId;

    @Test
    //@BeforeEach
    @DisplayName("pdf 파일, 문제 저장 테스트")
    void createProblem() {
        System.out.println("문제 저장테스트-------------------");
        ByteArrayResource file = createFile("test.pdf");

        WebTestClient.ResponseSpec responseSpec = webTestClient.post()
                .uri("/problems")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("file", file)
                        .with("name", "test1")
                        .with("timeLimit", 1d)
                        .with("memoryLimit", 1d))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader().valueMatches("Location", "/problems/[1-9]+[0-9]*");

        problemId = AcceptanceTestUtils.extractDomainIdFromCreatedResourceAddress(responseSpec);
    }

    @Test
    @DisplayName("전체 문제 정보 조회 테스트")
    void showAllProblems() {
        System.out.println("전체 문제 정보 조회 테스트-------------------");
        webTestClient.get()
                .uri("/problems")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.length", greaterThan(1));
    }

    @Test
    @DisplayName("문제 정보 조회 테스트")
    void showProblem() {
        System.out.println("문제 정보 조회 테스트-------------------");
        System.out.println("problemId: "+problemId);
        webTestClient.get()
                .uri("/problems/" + problemId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.name", "test");
    }

    @Test
    @DisplayName("문제 pdf 파일 다운로드 테스트")
    void downloadFile() {
        System.out.println("문제 다운로드 테스트-------------------");
        webTestClient.get()
                .uri("/problems/" + problemId + "/files")
                .accept(MediaType.APPLICATION_PDF)
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader().valueMatches(HttpHeaders.CONTENT_DISPOSITION, "inline");
    }

    @Test
    @DisplayName("문제, pdf 파일 수정 테스트")
    void updateProblem() {
        System.out.println("문제 파일 수정 테스트-------------------");
        ByteArrayResource file = createFile("update.pdf");

        webTestClient.post()
                .uri("/problems/" + problemId)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("file", file)
                        .with("name", "update")
                        .with("timeLimit", 3d)
                        .with("memoryLimit", 3d))
                .exchange()
                .expectStatus()
                .isNoContent();

        System.out.println("수정한파일 조회 테스트-------------------");
        webTestClient.get()
                .uri("/problems/" + problemId)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.name", "update");
    }

    @Test
    @DisplayName("문제, pdf 파일 삭제 테스트")
    void deleteProblem() {
        System.out.println("문제 파일 삭제 테스트-------------------");
        webTestClient.delete()
                .uri("/problems/" + problemId)
                .exchange()
                .expectStatus()
                .isNoContent();

        System.out.println("삭제되었는지 조회-------------------");
        webTestClient.get()
                .uri("/problems/" + problemId)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    @DisplayName("테스트 케이스 업로드 테스트")
    void uploadTestcases() {
        System.out.println("테스트 케이스 업로드 테스트-------------------");
        ByteArrayResource inputFile1 = createFile("1.in");
        ByteArrayResource inputFile2 = createFile("2.in");
        ByteArrayResource outputFile1 = createFile("1.out");
        ByteArrayResource outputFile2 = createFile("2.out");

        webTestClient.mutate().responseTimeout(Duration.ofMillis(30000)).build().post()
                .uri("/problems/" + "1" + "/testcase")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData("in", inputFile1)
                        .with("out", outputFile1)
                        .with("in", inputFile2)
                        .with("out", outputFile2))
                .exchange()
                .expectStatus()
                .isNoContent();
    }

    private ByteArrayResource createFile(String name) {
        return new ByteArrayResource(new byte[]{1, 2, 3}) {
            @Override
            public String getFilename() {
                return name;
            }
        };
    }
}
