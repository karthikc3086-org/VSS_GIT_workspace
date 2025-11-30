package com.example.restcaller2;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class CallerController {

	private final WebClient webClient = WebClient.builder()
			.baseUrl("http://localhost:8080")
			.build();

	@GetMapping(value = "/call", produces = MediaType.APPLICATION_JSON_VALUE)
	public String callHello() {
		return webClient.get()
				.uri("/api/hello")
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}
}
