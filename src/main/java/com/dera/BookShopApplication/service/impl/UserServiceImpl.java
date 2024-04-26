package com.dera.BookShopApplication.service.impl;

import com.dera.BookShopApplication.dto.UserDto;
import com.dera.BookShopApplication.enums.Gender;
import com.dera.BookShopApplication.enums.Role;
import com.dera.BookShopApplication.exceptions.EmailAlreadyExistsException;
import com.dera.BookShopApplication.model.User;
import com.dera.BookShopApplication.repository.UserRepository;
import com.dera.BookShopApplication.response.ApiResponse;
import com.dera.BookShopApplication.response.UserSignupResponse;
import com.dera.BookShopApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(UserDto userDto) {
        boolean userExists = userRepository.findUserByEmail(userDto.getEmail()).isPresent();
        if (userExists){
            throw new EmailAlreadyExistsException("Email already exists. Kindly log into your account");
        }
        User newUser = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .role(Role.USER)
                .password(userDto.getPassword())
                .gender(Gender.valueOf(String.valueOf(userDto.getGender())))
                .build();
        userRepository.save(newUser);

        UserSignupResponse signupResponse = UserSignupResponse.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Account created successfully", signupResponse));
    }
}
