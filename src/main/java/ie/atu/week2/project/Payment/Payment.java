package ie.atu.week2.project.Payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @NotBlank(message = "Name on card is required")
    private String nameOnCard;

    @NotBlank(message = "Bank is required")
    private String bank;

    @NotNull(message = "Card expiry date is required")
    private YearMonth cardExpiryDate;

    @Pattern(regexp = "\\d{16}", message = "Card number must be 16 digits")
    private String cardNumber;

   @Pattern(regexp = "\\d{3}", message = "CCV must be 3 digits")
    private Integer ccv;
}
