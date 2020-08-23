package com.qt.submit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class submitAcceptanceTest {
    @Autowired
    WebTestClient webTestClient;
    @Test
    @DisplayName("코드 제출 테스트")
    void submitCode(){
        System.out.println("코드제출 테스트");
        WebTestClient.ResponseSpec responseSpec=webTestClient.post()
                .uri("/problems/1/submit")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromFormData("source","#include <stdio.h>\n" +
                        "#include <math.h>\n" +
                        "\n" +
                        "int main(void)\n" +
                        "{\n" +
                        "    int t, x1, y1, r1, x2, y2, r2, result;\n" +
                        "    double distanse, subtract;    \n" +
                        "    scanf(\"%d\", &t);\n" +
                        "    \n" +
                        "    while(t--)\n" +
                        "    {\n" +
                        "        scanf(\"%d %d %d %d %d %d\", &x1, &y1, &r1, &x2, &y2, &r2);\n" +
                        "        distanse = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));    \n" +
                        "        subtract = r1 > r2 ? r1 - r2 : r2 - r1;\n" +
                        "        \n" +
                        "        if(distanse == 0 && r1 == r2) result = -1;   \n" +
                        "        else if(distanse < r1 + r2 && (subtract < distanse)) result = 2;    \n" +
                        "        else if(distanse == r1 + r2 || distanse == subtract) result = 1;    \n" +
                        "        else result = 0;    \n" +
                        "        \n" +
                        "        printf(\"%d\\n\", result);\n" +
                        "    }\n" +
                        "}")
                .with("language","c"))
                .exchange()
                .expectStatus()
                .isNoContent();
    }
}
