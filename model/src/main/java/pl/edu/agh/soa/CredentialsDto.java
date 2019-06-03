package pl.edu.agh.soa;

public class CredentialsDto {
    public String login;
    public String password;

    public CredentialsDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CredentialsDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
