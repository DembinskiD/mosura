package pl.mosura;

import lombok.Data;

@Data
public class LoginForm {

    private String username;
    private String password;

    public LoginForm() {
        super();
    }


}
