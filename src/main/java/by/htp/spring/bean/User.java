package by.htp.spring.bean;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int id;

    @Column(name = "login")
    @NotNull(message = "is required")
    @Size(min = 3,message = "must be more than 2 symbols!")
    private String login;

    @Column(name = "password")
    @NotNull(message = "is required")
    @Size(min = 3,message = "must be more than 2 symbols! ")
    private String password;

    @Column(name = "email")
    //@NotNull(message = "is required")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "enter correct format of email, any letters, digits, and symbols: _ ,-, . are possible!")
    private String email;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "userdetailsid")
    private UserDetails userDetails;


    public User() {
  this.userDetails=new UserDetails();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                login.equals(user.login) &&
                password.equals(user.password) &&
                email.equals(user.email) &&
                Objects.equals(userDetails, user.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, userDetails);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }
}

