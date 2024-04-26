package com.dera.BookShopApplication.controller;

import com.dera.BookShopApplication.dto.UserDto;
import com.dera.BookShopApplication.response.ApiResponse;
import com.dera.BookShopApplication.response.UserSignupResponse;
import com.dera.BookShopApplication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(@Valid @RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }
}
