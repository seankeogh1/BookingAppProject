package ie.atu.week2.project.Payment;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    //card storage keeps the card number
    private Map<String, Payment> payments = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> processPayment(@Valid @RequestBody Payment payment) {
        return ResponseEntity.ok("Payment processed successfully for " + payment.getNameOnCard());
    }

    @DeleteMapping("/{cardNumber}")
    public ResponseEntity<String> deleteCardDetails(@PathVariable String cardNumber){
        if(payments.containsKey(cardNumber)){
            payments.remove(cardNumber);
            return ResponseEntity.ok("Card details deleted successfully.");
        }else{
            return ResponseEntity.status(404).body("Card not found");
        }
    }

}
