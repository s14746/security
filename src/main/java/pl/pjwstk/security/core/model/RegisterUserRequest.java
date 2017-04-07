package pl.pjwstk.security.core.model;

public class RegisterUserRequest {
    private final String username;
    private final String password;
    private final String confirmPassword;
    private final String email;

    public RegisterUserRequest(String username, String password, String confirmPassword, String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getEmail() {
        return email;
    }
}
