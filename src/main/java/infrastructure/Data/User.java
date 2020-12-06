package infrastructure.Data;


import java.util.Objects;

public class User {
        public String id;
        public String username;
        public String userEmail;
        public String userPassword;

        public User(String id, String username, String userEmail, String userPassword) {
            this.id = id;
            this.username = username;
            this.userEmail = userEmail;
            this.userPassword = userPassword;
        }

    @Override
    public String toString() {
        return userEmail + ":" + userPassword + " ## " ;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, userEmail, userPassword);
    }

}
