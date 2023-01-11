package com.lucascosta.jaegertracingclient.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@NoArgsConstructor
@Getter
@Setter
public class JaegerClientService {

    @Autowired
    WebClient webClient;
    public Mono<String> get(Integer id) {
        return webClient.get()
                .uri("http://localhost:8082/jaeger/server/" + id)
                .retrieve()
                .bodyToMono(String.class);
    }
}
