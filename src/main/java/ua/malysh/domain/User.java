package ua.malysh.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.validation.Validated;

import java.util.Objects;

@Validated
@MappedEntity("users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private final String firstName;
    private final String lastName;
    private final String nickname;
    private final String email;
    private final String password;
    
    public User(
        String firstName,
        String lastName,
        String nickname,
        String email,
        String password
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(
            firstName,
            user.firstName
        ) && Objects.equals(lastName, user.lastName) && Objects.equals(
            nickname,
            user.nickname
        ) && Objects.equals(email, user.email) && Objects.equals(
            password,
            user.password
        );
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, nickname, email, password);
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
}
