package com.avulaj.webtestclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.ByteBuffer;
import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class MyControllerTest {
    @Autowired
    private WebTestClient testClient;

    @Test
    public void testSmall() {
        byte[] b = new byte[1024];
        new Random().nextBytes(b);
        testClient.post()
                .uri("/test")
                .bodyValue(ByteBuffer.wrap(b))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testLarge() {
        byte[] b = new byte[4000000];
        new Random().nextBytes(b);
        testClient.post()
                .uri("/test")
                .bodyValue(ByteBuffer.wrap(b))
                .exchange()
                .expectStatus().isOk();
    }
}
