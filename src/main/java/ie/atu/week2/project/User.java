package ie.atu.week2.project;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User
{
    @NotBlank
    private String Firstname;
    @NotBlank
    private String Lastname;
    private String Email;
    private String Password;
    private String Country;

}
