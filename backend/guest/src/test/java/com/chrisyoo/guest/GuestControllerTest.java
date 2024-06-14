package com.chrisyoo.guest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = "ski")
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}"})
class GuestControllerTest {
    TestRestTemplate testRestTemplate;

    @Autowired
    public GuestControllerTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    @Test
    void getSkiResorts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-type", MediaType.APPLICATION_JSON.toString());
        var httpEntity = new HttpEntity<>(new String(), httpHeaders);

        var response = testRestTemplate
                .exchange("api/v1/guests", HttpMethod.GET, httpEntity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}