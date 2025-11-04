package ie.atu.week2.project.Payment;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping
    public ResponseEntity<String> processPayment(@Valid @RequestBody Payment payment) {
        return ResponseEntity.ok("Payment processed successfully for " + payment.getNameOnCard());
    }
}
