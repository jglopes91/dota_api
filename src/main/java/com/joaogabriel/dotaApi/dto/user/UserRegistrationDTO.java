package com.joaogabriel.dotaApi.dto.user;

import com.joaogabriel.dotaApi.entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRegistrationDTO {

    @NotNull(message = "field name cannot be Null")
    @NotBlank(message = "field name cannot be Blank")
    @NotEmpty(message = "field name cannot be Empty")
    private String name;

    @NotNull(message = "field password cannot be Null")
    @NotBlank(message = "field password cannot be Blank")
    @NotEmpty(message = "field password cannot be Empty")
    private String password;

    @NotNull(message = "field email cannot be Null")
    @NotBlank(message = "field email cannot be Blank")
    @NotEmpty(message = "field email cannot be Empty")
    @Email(message = "field email does not valid")
    private String email;

    public UserEntity toUserEntity(final String passwordEncoded) {
        return new UserEntity(
                name = this.name,
                email = this.email,
                password = passwordEncoded
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
