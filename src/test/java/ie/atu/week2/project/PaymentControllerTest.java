package ie.atu.week2.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import ie.atu.week2.project.Payment.PaymentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void processPayment_returns200_andSuccessMessage() throws Exception {
        String paymentJson = """
            {
              "nameOnCard": "John Doe",
              "bank": "AIB",
              "cardExpiryDate": "2030-12",
              "cardNumber": "1234567812345678"
            }
            """;

        mockMvc.perform(post("/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paymentJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Payment processed successfully for John Doe"));
    }

    @Test
    void deleteCardDetails_whenCardNotStored_returns404() throws Exception {
        mockMvc.perform(delete("/payments/{cardNumber}", "1234567812345678"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Card not found"));
    }

    @Test
    void deleteCardDetails_afterPostingPayment_returns200() throws Exception {
        String cardNumber = "1234567812345678";

        String paymentJson = """
            {
              "nameOnCard": "John Doe",
              "bank": "AIB",
              "cardExpiryDate": "2030-12",
              "cardNumber": "%s"
            }
            """.formatted(cardNumber);

        mockMvc.perform(post("/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paymentJson))
                .andExpect(status().isOk());


        mockMvc.perform(delete("/payments/{cardNumber}", cardNumber))
                .andExpect(status().isOk())
                .andExpect(content().string("Card details deleted successfully."));
    }
}

