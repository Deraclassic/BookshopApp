package com.dera.BookShopApplication.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignupResponse {
    private String firstName;
    private String lastName;
    private String email;
}
