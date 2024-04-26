package com.dera.BookShopApplication.dto;

import com.dera.BookShopApplication.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    @NotBlank(message = "Book title must not be blank")
    private String title;

    @NotBlank(message = "Author must not be blank")
    private  String author;

    @NotBlank(message = "Pages must not be blank")
    private int pages;

    @NotBlank(message = "Book status must not be blank")

    private BookStatus bookStatus;

}
