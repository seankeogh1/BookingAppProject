package ie.atu.week2.project;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
@Value

public class User
{

    @NotBlank(message = "Can not be left blank")
    private String Firstname;
    @NotBlank(message = "Can not be left blank")
    private String Lastname;
    @NotBlank
    private String Email;
    @NotBlank
    private String Password;
    @NotBlank
    private String Country;
    @NotBlank(message = "Can not be left blank")
    private double Id;


}
