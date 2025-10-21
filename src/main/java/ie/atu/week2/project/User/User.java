package ie.atu.week2.project.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank(message = "First name cannot be left blank")
    private String firstname;

    @NotBlank(message = "Last name cannot be left blank")
    private String lastname;

    @NotBlank(message = "Email cannot be left blank")
    private String email;

    @NotBlank(message = "Password cannot be left blank")
    private String password;

    @NotBlank(message = "Country cannot be left blank")
    private String country;

    @NotNull(message = "ID cannot be null")
    private Long id;

   // Generate Constructurs and Getter and Setters.
}
