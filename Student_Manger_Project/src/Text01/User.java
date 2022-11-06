package Text01;

public class User {
    private String username;
    private String password;
    private String personId;
    private String phoneNumber;

    public User(String username, String password, String personId, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.personId = personId;
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerson(String personId) {
        this.personId = personId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPersonId() {
        return personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User() {
    }
}
