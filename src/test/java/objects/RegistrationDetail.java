package objects;

public class RegistrationDetail {

    private String name;
    private String email;
    private  String password;

    public RegistrationDetail(String username, String email, String password){
        this.name = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
