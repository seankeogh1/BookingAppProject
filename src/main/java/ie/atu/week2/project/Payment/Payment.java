package ie.atu.week2.project.Payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

//@Data @AllArgsConstructor @NoArgsConstructor
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

    public Payment(String nameOnCard, String bank, @NotNull(message = "Card expiry date is required") YearMonth cardExpiryDate, String cardNumber, Integer ccv) {
        this.nameOnCard = nameOnCard;
        this.bank = bank;
        this.cardExpiryDate = cardExpiryDate;
        this.cardNumber = cardNumber;
        this.ccv = ccv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public YearMonth getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(YearMonth cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCcv() {
        return ccv;
    }

    public void setCcv(Integer ccv) {
        this.ccv = ccv;
    }
}
