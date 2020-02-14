package by.htp.spring.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "userdetails")
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduserdetails")
    private int id;

    @Column(name = "name")
    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-Z]+",message = "fill this field by letters!")
    private String name;

    @Column(name = "surname")
    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-Z]+",message = "fill this field by letters!")
    private String surName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    public UserDetails(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return id == that.id &&
                name.equals(that.name) &&
                surName.equals(that.surName) &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, role);
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", role=" + role +
                '}';
    }
}
