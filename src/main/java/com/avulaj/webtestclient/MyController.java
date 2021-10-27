package com.avulaj.webtestclient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {
    @PostMapping("/test")
    public Mono<String> test(@RequestBody byte[] bytes) {
        return Mono.just("success!");
    }
}
