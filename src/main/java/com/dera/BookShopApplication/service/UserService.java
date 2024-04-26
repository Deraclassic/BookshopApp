package com.dera.BookShopApplication.service;

import com.dera.BookShopApplication.dto.UserDto;
import com.dera.BookShopApplication.response.ApiResponse;
import com.dera.BookShopApplication.response.UserSignupResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(UserDto userDto);
}
