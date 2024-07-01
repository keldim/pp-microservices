package com.chrisyoo.guest;

import com.chrisyoo.kafka.SkiEventsProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GuestController.class)
class GuestControllerTest {

    MockMvc mockMvc;
    @MockBean
    SkiEventsProducer skiEventsProducer;
    @MockBean
    GuestService guestService;

    @Autowired
    public GuestControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void getSkiResorts() throws Exception {
        when(skiEventsProducer.sendSkiResortsEvent()).thenReturn(null);

        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/guests"))
                .andExpect(status().isOk());
    }
}