package app.ewallet.ewallet.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountModel extends PersistenceModel{

    private String email;
    private String fullName;
    private String phoneNumber;
    private String role;

}
