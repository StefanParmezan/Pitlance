package com.example.JpaPractice.Models.User.DTO;

import com.example.JpaPractice.Models.User.User;

import java.util.Objects;

/**
 * DTO for {@link User}
 */
public class UserDto {
    private final String password;
    private final String username;

    public UserDto(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.password, entity.password) &&
                Objects.equals(this.username, entity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "password = " + password + ", " +
                "username = " + username + ")";
    }
}