package com.dera.BookShopApplication.dto;

import com.dera.BookShopApplication.enums.Gender;
import com.dera.BookShopApplication.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Size(min = 2, max = 125, message = "firstname must be at least 2 characters long")
    @NotBlank(message = "Firstname must not be blank")
    private String firstName;

    @Size(min = 2, max = 125, message = "lastname must be at least 2 characters long")
    @NotBlank(message = "Lastname must not be blank")
    private String lastName;

    @Size(min = 2, max = 125)
    @NotBlank(message = "email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Size(min = 6, max = 65, message = "password must be at least 2 characters long")
    @NotBlank(message = "password must not be blank")
    private String password;

    @Size(min = 6, max = 65, message = "confirm password must be at least 2 characters long")
    @NotBlank(message = "confirm password must not be blank")
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
