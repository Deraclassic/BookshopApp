package com.dera.BookShopApplication.service;

import com.dera.BookShopApplication.dto.BookDto;

public interface BookService {
    BookDto createBook(Long id, BookDto bookDto);
    BookDto getBookById(Long id);
}
