package com.qt;

import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

public class AcceptanceTestUtils {
    public static String extractDomainIdFromCreatedResourceAddress(WebTestClient.ResponseSpec responseSpec) {
        return Objects.requireNonNull(responseSpec.returnResult(String.class)
                .getResponseHeaders()
                .get("location")).get(0)
                .split("/.+/")[1];
    }
}
