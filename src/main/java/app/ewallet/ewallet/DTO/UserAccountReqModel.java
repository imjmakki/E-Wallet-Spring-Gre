package app.ewallet.ewallet.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import app.ewallet.ewallet.Utility.FieldValueMatch;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldValueMatch.List({
        @FieldValueMatch(
                field = "password",
                fieldMatch = "verifyPassword",
                message = "password must match"
        )
})
public class UserAccountReqModel {

    @NotBlank
    @Email(message = "email invalid")
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String verifyPassword;

    @NotBlank
    private String fullName;

    @NotBlank
    @Pattern(regexp = "(^[0-9]+$|^$)", message = "number only")
    private String phoneNumber;

    @NotBlank
    private String role;
}
