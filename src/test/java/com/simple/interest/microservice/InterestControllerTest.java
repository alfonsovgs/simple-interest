package com.simple.interest.microservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.interest.microservice.domain.entities.CreditRequest;
import com.simple.interest.microservice.domain.entities.Interest;
import com.simple.interest.microservice.domain.services.InterestCalculator;
import com.simple.interest.microservice.presentation.api.requests.GetInterestRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class InterestControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private InterestCalculator interestCalculator;

    @Test
    public void shouldCalculateInterest_whenValidRequest_thenReturnOk() throws Exception {
        GetInterestRequest request = new GetInterestRequest(1_000, 4, 10);
        CreditRequest creditRequest = CreditRequest.of(request.getAmount(), request.getTerms(), request.getRate());

        when(interestCalculator.Generate(creditRequest)).thenReturn(interestsExpected());

        mvc.perform(MockMvcRequestBuilders
                    .post("/api/interests/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(toJsonString(request))
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(interestCalculator).Generate(creditRequest);
    }

    @Test
    public void shouldGetError_whenRequestIsInvalid_thenReturnBadRequest() throws Exception {
        GetInterestRequest request = new GetInterestRequest(1_000_000, 4, 10);

        mvc.perform(MockMvcRequestBuilders
                        .post("/api/interests/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJsonString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.details").exists());
    }

    private static String toJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Interest[] interestsExpected() {
        final LocalDate paymentDate = LocalDate.now();

        Interest[] interests = new Interest[4];
        interests[0] = new Interest(1, 275, paymentDate.plusWeeks(1));
        interests[1] = new Interest(2, 268.75,  paymentDate.plusWeeks(2));
        interests[2] = new Interest(3, 262.50,  paymentDate.plusWeeks(3));
        interests[3] = new Interest(4, 256.25,  paymentDate.plusWeeks(4));

        return interests;
    }
}
