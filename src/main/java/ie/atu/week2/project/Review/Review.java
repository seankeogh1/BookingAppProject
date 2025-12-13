package ie.atu.week2.project.Review;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @NotBlank(message = "First name cannot be left blank")
    private String name;

    @NotBlank(message = "Last name cannot be left blank")
    private String lastname;

    @NotNull(message = "Leave a Rating 1-5")
    @Min(1)
    @Max(5)
    private Integer rating;

    @NotBlank(message = "Comment cannot be left blank")
    private String comment;

    @Id
    @NotBlank(message = "Enter unique Id")
    private String ReviewId;

    private String date = LocalDate.now().toString();

}
