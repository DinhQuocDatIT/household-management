package dinhquocdat.backend.dto.request;

public class SignupRequest {

    private String username;
    private String password;


    public SignupRequest(String fullName, String username, String password, String email) {

        this.username = username;
        this.password = password;

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
